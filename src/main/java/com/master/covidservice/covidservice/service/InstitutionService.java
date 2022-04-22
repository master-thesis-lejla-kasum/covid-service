package com.master.covidservice.covidservice.service;

import com.master.covidservice.covidservice.domain.Institution;
import com.master.covidservice.covidservice.exception.EntityNotFoundException;
import com.master.covidservice.covidservice.model.InstitutionEntity;
import com.master.covidservice.covidservice.repository.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class InstitutionService {

    @Autowired
    InstitutionRepository institutionRepository;

    public Institution add(Institution institution) {
        return institutionRepository.save(mapDomainToEntity(institution)).toDomain();
    }

    public Institution update(UUID id, Institution institution) {
        Optional<InstitutionEntity> institutionEntity = institutionRepository.findById(id);

        if (!institutionEntity.isPresent()) {
            throw new EntityNotFoundException(String.format("Institution with id=%s does not exist.", id));
        }

        InstitutionEntity entity = institutionEntity.get();
        entity.setIdentificationNumber(institution.getIdentificationNumber());
        entity.setName(institution.getName());
        entity.setEntity(institution.getEntity());
        entity.setCanton(institution.getCanton());
        entity.setMunicipality(institution.getMunicipality());

        return institutionRepository.save(entity).toDomain();
    }

    public void deleteById(UUID id) {
        if (!institutionRepository.existsById(id)) {
            throw new EntityNotFoundException(String.format("Institution with id=%s does not exist.", id));
        }
        institutionRepository.deleteById(id);
    }

    private InstitutionEntity mapDomainToEntity(Institution institution) {
        InstitutionEntity entity = new InstitutionEntity();
        entity.setId(institution.getId());
        entity.setIdentificationNumber(institution.getIdentificationNumber());
        entity.setName(institution.getName());
        entity.setEntity(institution.getEntity());
        entity.setCanton(institution.getCanton());
        entity.setMunicipality(institution.getMunicipality());

        return entity;
    }
}
