package com.master.covidservice.covidservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StatisticSearchRequest {
    private String entity;
    private String canton;
    private String municipality;
    private Date startDate;
    private Date endDate;
}
