package com.master.covidservice.covidservice.controller;

import com.master.covidservice.covidservice.domain.Application;
import com.master.covidservice.covidservice.domain.ApplicationType;
import com.master.covidservice.covidservice.dto.ApplicationSearchRequest;
import com.master.covidservice.covidservice.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/application")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @GetMapping
    public List<Application> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String surname,
            @RequestParam(required = false) ApplicationType type,
            @RequestParam(required = false) Boolean processed
    ) {
        return applicationService.getAll(new ApplicationSearchRequest(name, surname, type, processed));
    }

    @GetMapping("/{id}")
    public Application getById(@PathVariable UUID id) {
        return applicationService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Valid
    public Application create(@Valid @RequestBody Application application) {
        return applicationService.add(application);
    }

    @PutMapping("/{id}")
    @Valid
    public Application update(@PathVariable UUID id, @RequestParam boolean processingStatus) {
        return applicationService.updateProcessingStatus(id, processingStatus);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        applicationService.deleteById(id);
    }
}
