package com.master.covidservice.covidservice.model;

import com.master.covidservice.covidservice.domain.Application;
import com.master.covidservice.covidservice.domain.Institution;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "institution")
@Getter
@Setter
public class InstitutionEntity {
    @Id
    private UUID id;

    private String name;
    private String identificationNumber;
    private String entity;
    private String canton;
    private String municipality;

    @OneToMany(mappedBy = "institution")
    private List<StatisticEntity> statistic;

    @OneToMany(mappedBy = "institution")
    private List<ArticleEntity> articles;

    @OneToMany(mappedBy = "institution")
    private List<ApplicationEntity> applications;

    public Institution toDomain() {
        Institution institution = new Institution();
        institution.setId(this.getId());
        institution.setName(this.getName());
        institution.setIdentificationNumber(this.getIdentificationNumber());
        institution.setEntity(this.getEntity());
        institution.setCanton(this.getCanton());
        institution.setMunicipality(this.getMunicipality());

        return institution;
    }

    public Institution toExtendedDomain() {
        Institution institution = this.toDomain();

        institution.setStatistic(this.statistic.stream()
                .map(StatisticEntity::toDomain)
                .collect(Collectors.toList())
        );

        institution.setArticles(this.articles.stream()
                .map(ArticleEntity::toDomain)
                .collect(Collectors.toList())
        );

        institution.setApplications(this.applications.stream()
                .map(ApplicationEntity::toDomain)
                .collect(Collectors.toList())
        );

        return institution;
    }
}
