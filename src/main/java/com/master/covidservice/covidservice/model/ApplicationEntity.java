package com.master.covidservice.covidservice.model;

import com.master.covidservice.covidservice.domain.Application;
import com.master.covidservice.covidservice.domain.ApplicationType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "application")
@Getter
@Setter
public class ApplicationEntity {
    @Id
    @GeneratedValue
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

    @ManyToOne
    @JoinColumn(name = "institution_id", nullable = false)
    private InstitutionEntity institution;

    public Application toDomain() {
        Application application = new Application();

        application.setId(this.getId());
        application.setType(this.getType());
        application.setDate(this.getDate());
        application.setPersonalId(this.getPersonalId());
        application.setIdentificationId(this.getIdentificationId());
        application.setName(this.getName());
        application.setSurname(this.getSurname());
        application.setBirthDate(this.getBirthDate());
        application.setPhoneNumber(this.getPhoneNumber());
        application.setEmail(this.getEmail());
        application.setTestingDate(this.getTestingDate());
        application.setTestId(this.getTestId());
        application.setProcessed(this.isProcessed());

        return application;
    }

    public Application toExtendedDomain() {
        Application application = this.toDomain();

        application.setInstitution(this.institution.toDomain());

        return application;
    }
}
