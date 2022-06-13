package com.master.covidservice.covidservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArticleSearchRequest {
    private Integer pageNumber;
    private Integer pageSize;
    private String entity;
    private String canton;
}
