package com.master.covidservice.covidservice.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Article {
    private UUID id;
    private String title;
    private Date date;
    private String content;
    private boolean active;
    private Institution institution;
}
