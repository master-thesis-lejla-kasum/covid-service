package com.master.covidservice.covidservice.repository.application;

import com.master.covidservice.covidservice.model.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ApplicationRepository extends JpaRepository<ApplicationEntity, UUID>,ApplicationCustomRepository {
}
