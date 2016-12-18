package rs.ac.uns.ftn.informatika.entity;

import javax.persistence.*;

@Entity
@Table(name = "scientific_paper_category")
public class ScientificPaperCategory {

    Integer id;
    String name;

    public ScientificPaperCategory() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "category_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}