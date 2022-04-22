package com.master.covidservice.covidservice.repository;

import com.master.covidservice.covidservice.model.InstitutionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InstitutionRepository extends JpaRepository<InstitutionEntity, UUID> {
}
