/* eslint-disable no-param-reassign */
import { action, observable } from 'mobx';
import formFieldFactory from './formFieldFactory';

function formFactory(formFields = {}) {
  const fieldNames = Object.keys(formFields);
  const allFields = fieldNames.reduce((fields, name) => {
    const fieldConfig = formFields[name];
    fieldConfig.name = name;

    const formField = formFieldFactory(fieldConfig);
    fields[name] = formField;

    return fields;
  }, {});

  const state = observable({
    fieldNames,
    fields: observable.ref(allFields),
    get isValid() {
      return this.fieldNames
        .map(name => this.fields[name].isValid())
        .filter(isValid => isValid === false)
          .length === 0;
    },
    get isDirty() {
      return this.fieldNames
      .some(name => this.fields[name].isDirty);
    },
    get fieldValues() {
      return this.fieldNames
      .reduce((dataSet, name) => {
        const formField = this.fields[name];
        dataSet[name] = formField.getValue();

        return dataSet;
      }, {});
    },
  });

  const publicAPI = {
    isValid: () => state.isValid,
    isDirty: () => state.isDirty,
    getFields: () => state.fields,
    getFieldValue: fieldName => state.fields[fieldName],
    getAllValues: () => state.fieldValues,

    reset: action('reset', () => {
      state.fieldNames.forEach(name => state.fields[name].reset());
    })
  };

  return publicAPI;
}

export default formFactory;
