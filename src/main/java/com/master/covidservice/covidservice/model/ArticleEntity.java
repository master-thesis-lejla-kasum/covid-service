package com.master.covidservice.covidservice.model;

import com.master.covidservice.covidservice.domain.Article;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "article")
@Getter
@Setter
public class ArticleEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private String title;
    private Date date;
    private String content;
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "institution_id", nullable = false)
    private InstitutionEntity institution;

    public Article toDomain() {
        Article article = new Article();

        article.setId(this.getId());
        article.setTitle(this.getTitle());
        article.setDate(this.getDate());
        article.setContent(this.getContent());
        article.setActive(this.isActive());

        return article;
    }

    public Article toExtendedDomain() {
        Article article = this.toDomain();

        article.setInstitution(this.institution.toDomain());

        return article;
    }
}
