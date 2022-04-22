package com.master.covidservice.covidservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Statistic {
    private UUID id;
    @NotNull(message = "Date cannot be null.")
    private Date date;
    @NotNull(message = "Tested cases cannot be null.")
    private Integer testedCases;
    @NotNull(message = "Positive cases cannot be null.")
    private Integer positiveCases;
    @NotNull(message = "Recover cases cannot be null.")
    private Integer recoverCases;
    @NotNull(message = "Death cases cannot be null.")
    private Integer deathCases;
    @NotNull(message = "Hospitalized cases cannot be null.")
    private Integer hospitalizedCases;
    @NotNull(message = "Vaccinated cases cannot be null.")
    private Integer vaccinatedCases;
    @NotNull(message = "Institution cannot be null.")
    private Institution institution;
}
