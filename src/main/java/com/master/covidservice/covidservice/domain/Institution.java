package com.master.covidservice.covidservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Institution {
    @NotNull(message = "Id cannot be null.")
    private UUID id;
    @NotEmpty(message = "Identification number cannot be null or empty.")
    private String identificationNumber;
    @NotEmpty(message = "Name cannot be null or empty.")
    private String name;
    @NotNull(message = "Entity cannot be null or empty.")
    private String entity;
    private String canton;
    private String municipality;
    private List<Statistic> statistic;
    private List<Article> articles;
    private List<Application> applications;
}
