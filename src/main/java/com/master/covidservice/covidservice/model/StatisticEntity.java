package com.master.covidservice.covidservice.model;

import com.master.covidservice.covidservice.domain.Statistic;
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
@Table(name = "statistic")
@Getter
@Setter
public class StatisticEntity {
    @Id
    @GeneratedValue
    private UUID id;

    private Date date;
    private Integer testedCases;
    private Integer positiveCases;
    private Integer recoverCases;
    private Integer deathCases;
    private Integer hospitalizedCases;
    private Integer vaccinatedCases;

    @ManyToOne
    @JoinColumn(name = "institution_id", nullable = false)
    private InstitutionEntity institution;

    public Statistic toDomain() {
        Statistic statistic = new Statistic();

        statistic.setId(this.getId());
        statistic.setDate(this.getDate());
        statistic.setTestedCases(this.getTestedCases());
        statistic.setPositiveCases(this.getPositiveCases());
        statistic.setRecoverCases(this.getRecoverCases());
        statistic.setDeathCases(this.getDeathCases());
        statistic.setHospitalizedCases(this.getHospitalizedCases());
        statistic.setVaccinatedCases(this.getVaccinatedCases());

        return statistic;
    }

    public Statistic toExtendedDomain() {
        Statistic statistic = this.toDomain();

        statistic.setInstitution(this.institution.toDomain());

        return statistic;
    }
}
