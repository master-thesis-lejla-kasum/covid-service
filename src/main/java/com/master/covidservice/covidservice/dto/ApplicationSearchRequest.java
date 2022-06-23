package com.master.covidservice.covidservice.dto;


import com.master.covidservice.covidservice.domain.ApplicationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationSearchRequest {
    private String name;
    private String surname;
    private ApplicationType type;
    private Boolean processed;
}
