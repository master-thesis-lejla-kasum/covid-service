package com.master.covidservice.covidservice.controller;

import com.master.covidservice.covidservice.domain.Institution;
import com.master.covidservice.covidservice.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/institution")
public class InstitutionController {
    @Autowired
    private InstitutionService institutionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Valid
    public Institution create(@Valid @RequestBody Institution institution) {
        return institutionService.add(institution);
    }

    @PutMapping("/{id}")
    @Valid
    public Institution update(@PathVariable UUID id, @Valid @RequestBody Institution institution) {
        return institutionService.update(id, institution);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        institutionService.deleteById(id);
    }
}
