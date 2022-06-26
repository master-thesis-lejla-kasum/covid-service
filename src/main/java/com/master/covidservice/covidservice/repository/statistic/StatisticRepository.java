package com.master.covidservice.covidservice.repository.statistic;

import com.master.covidservice.covidservice.model.StatisticEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StatisticRepository extends JpaRepository<StatisticEntity, UUID>, StatisticCustomRepository {
}
