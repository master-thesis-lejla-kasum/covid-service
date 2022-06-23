package com.master.covidservice.covidservice.service;

import com.master.covidservice.covidservice.domain.Application;
import com.master.covidservice.covidservice.dto.ApplicationSearchRequest;
import com.master.covidservice.covidservice.exception.BadRequestException;
import com.master.covidservice.covidservice.model.ApplicationEntity;
import com.master.covidservice.covidservice.model.InstitutionEntity;
import com.master.covidservice.covidservice.repository.application.ApplicationRepository;
import com.master.covidservice.covidservice.repository.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;
    @Autowired
    private InstitutionRepository institutionRepository;

    public List<Application> getAll(ApplicationSearchRequest request) {
        return applicationRepository.search(request).stream()
                .map(ApplicationEntity::toExtendedDomain)
                .collect(Collectors.toList());
    }

    public Application getById(UUID id) {
        return applicationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Application with id=%s does not exist.", id)))
                .toExtendedDomain();
    }

    public Application add(Application application) {
        ApplicationEntity entity = mapDomainToEntity(application);

        entity.setInstitution(getInstitution(application.getInstitution().getId()));

        return applicationRepository.save(entity).toExtendedDomain();
    }

    public Application updateProcessingStatus(UUID id, boolean status) {
        ApplicationEntity entity = applicationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Application with id=%s does not exist.", id)));

        entity.setProcessed(status);

        return applicationRepository.save(entity).toExtendedDomain();
    }

    public void deleteById(UUID id) {
        if (!applicationRepository.existsById(id)) {
            throw new EntityNotFoundException(String.format("Application with id=%s does not exist.", id));
        }
        applicationRepository.deleteById(id);
    }

    private ApplicationEntity mapDomainToEntity(Application application) {
        ApplicationEntity entity = new ApplicationEntity();

        entity.setType(application.getType());
        entity.setDate(application.getDate());
        entity.setPersonalId(application.getPersonalId());
        entity.setIdentificationId(application.getIdentificationId());
        entity.setName(application.getName());
        entity.setSurname(application.getSurname());
        entity.setBirthDate(application.getBirthDate());
        entity.setPhoneNumber(application.getPhoneNumber());
        entity.setEmail(application.getEmail());
        entity.setTestingDate(application.getTestingDate());
        entity.setTestId(application.getTestId());
        entity.setProcessed(application.isProcessed());

        return entity;
    }

    private InstitutionEntity getInstitution(UUID id) {
        Optional<InstitutionEntity> institutionEntity = institutionRepository.findById(id);
        if (!institutionEntity.isPresent()) {
            throw new BadRequestException(String.format("Institution with id=%s does not exists.", id));
        }
        return institutionEntity.get();
    }
}
