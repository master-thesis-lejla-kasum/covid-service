package com.master.covidservice.covidservice.model;

import com.master.covidservice.covidservice.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "article")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private String title;
    private Date date;
    @Column(length = 10000)
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
