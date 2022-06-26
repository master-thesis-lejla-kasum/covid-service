package com.master.covidservice.covidservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomStatisticEntity {
    private Date date;
    private long testedCases;
    private long positiveCases;
    private long recoverCases;
    private long deathCases;
    private long hospitalizedCases;
    private long vaccinatedCases;
}
