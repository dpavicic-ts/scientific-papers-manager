package rs.ac.uns.ftn.informatika.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "scientific_paper")
public class ScientificPaper {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String title;

    String anAbstract;

    String keywords;

    @ManyToOne(fetch = FetchType.LAZY)
    Category category;

    @Temporal(TemporalType.DATE)
    Date publishDate;

    String fileName;

    String elasticSearchId;

    public ScientificPaper() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnAbstract() {
        return anAbstract;
    }

    public void setAnAbstract(String anAbstract) {
        this.anAbstract = anAbstract;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getElasticSearchId() {
        return elasticSearchId;
    }

    public void setElasticSearchId(String elasticSearchId) {
        this.elasticSearchId = elasticSearchId;
    }
}
