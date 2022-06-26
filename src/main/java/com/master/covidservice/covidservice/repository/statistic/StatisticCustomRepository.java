package com.master.covidservice.covidservice.repository.statistic;

import com.master.covidservice.covidservice.dto.StatisticSearchRequest;
import com.master.covidservice.covidservice.model.CustomStatisticEntity;
import com.master.covidservice.covidservice.model.StatisticEntity;

import java.util.List;

public interface StatisticCustomRepository {

    List<CustomStatisticEntity> search(StatisticSearchRequest request);
}
