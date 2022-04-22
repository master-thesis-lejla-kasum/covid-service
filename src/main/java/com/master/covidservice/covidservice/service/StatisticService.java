package com.master.covidservice.covidservice.service;

import com.master.covidservice.covidservice.domain.Statistic;
import com.master.covidservice.covidservice.exception.BadRequestException;
import com.master.covidservice.covidservice.model.InstitutionEntity;
import com.master.covidservice.covidservice.model.StatisticEntity;
import com.master.covidservice.covidservice.repository.InstitutionRepository;
import com.master.covidservice.covidservice.repository.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StatisticService {
    @Autowired
    private StatisticRepository statisticRepository;
    @Autowired
    private InstitutionRepository institutionRepository;

    public List<Statistic> getAll() {
        return statisticRepository.findAll().stream()
                .map(StatisticEntity::toExtendedDomain)
                .collect(Collectors.toList());
    }

    public Statistic add(Statistic statistic) {
        StatisticEntity entity = mapDomainToEntity(statistic);

        entity.setInstitution(getInstitution(statistic.getInstitution().getId()));

        return statisticRepository.save(entity).toExtendedDomain();
    }

    private StatisticEntity mapDomainToEntity(Statistic statistic) {
        StatisticEntity entity = new StatisticEntity();
        entity.setDate(statistic.getDate());
        entity.setTestedCases(statistic.getTestedCases());
        entity.setPositiveCases(statistic.getPositiveCases());
        entity.setRecoverCases(statistic.getRecoverCases());
        entity.setHospitalizedCases(statistic.getHospitalizedCases());
        entity.setDeathCases(statistic.getDeathCases());
        entity.setVaccinatedCases(statistic.getVaccinatedCases());

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
