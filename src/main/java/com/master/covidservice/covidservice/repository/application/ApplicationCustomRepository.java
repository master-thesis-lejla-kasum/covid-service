package com.master.covidservice.covidservice.repository.application;

import com.master.covidservice.covidservice.dto.ApplicationSearchRequest;
import com.master.covidservice.covidservice.model.ApplicationEntity;

import java.util.List;

public interface ApplicationCustomRepository {

    List<ApplicationEntity> search(ApplicationSearchRequest request);
}
