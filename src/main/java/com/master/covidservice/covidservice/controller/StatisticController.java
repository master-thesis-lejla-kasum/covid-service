package com.master.covidservice.covidservice.controller;

import com.master.covidservice.covidservice.domain.Article;
import com.master.covidservice.covidservice.domain.Statistic;
import com.master.covidservice.covidservice.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/statistic")
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @GetMapping
    public List<Statistic> getAll() {
        return statisticService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Valid
    public Statistic create(@Valid @RequestBody Statistic statistic) {
        return statisticService.add(statistic);
    }
}
