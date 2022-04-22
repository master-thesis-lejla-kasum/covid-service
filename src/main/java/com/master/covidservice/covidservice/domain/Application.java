package com.master.covidservice.covidservice.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Application {
    private UUID id;
    private ApplicationType type;
    private Date date;
    private String personalId;
    private String identificationId;
    private String name;
    private String surname;
    private Date birthDate;
    private String phoneNumber;
    private String email;
    private Date testingDate;
    private String testId;
    private boolean processed;
    private Institution institution;
}
