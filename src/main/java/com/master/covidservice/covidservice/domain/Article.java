package com.master.covidservice.covidservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Article {
    private UUID id;
    @NotEmpty(message = "Title cannot be null or empty.")
    private String title;
    @NotNull(message = "Date cannot be null.")
    private Date date;
    @NotEmpty(message = "Title cannot be null or empty.")
    private String content;
    private boolean active;
    @NotNull(message = "Institution cannot be null.")
    private Institution institution;
}
