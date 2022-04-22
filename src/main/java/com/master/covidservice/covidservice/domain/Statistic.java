package com.master.covidservice.covidservice.domain;

import com.master.covidservice.covidservice.model.InstitutionEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Statistic {
    private UUID id;
    private Date date;
    private Integer testedCases;
    private Integer positiveCases;
    private Integer recoverCases;
    private Integer deathCases;
    private Integer hospitalizedCases;
    private Integer vaccinatedCases;
    private Institution institution;
}
