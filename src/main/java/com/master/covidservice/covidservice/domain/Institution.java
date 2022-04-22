package com.master.covidservice.covidservice.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Institution {
    private UUID id;
    private String name;
    private String identificationNumber;
    private String entity;
    private String canton;
    private String municipality;
    private List<Statistic> statistic;
    private List<Article> articles;
    private List<Application> applications;
}
