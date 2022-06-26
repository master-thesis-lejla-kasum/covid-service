package com.master.covidservice.covidservice.controller;

import com.master.covidservice.covidservice.domain.Article;
import com.master.covidservice.covidservice.domain.Statistic;
import com.master.covidservice.covidservice.dto.StatisticSearchRequest;
import com.master.covidservice.covidservice.model.CustomStatisticEntity;
import com.master.covidservice.covidservice.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/statistic")
public class StatisticController {

    @Autowired
    private StatisticService statisticService;

    @GetMapping
    public List<CustomStatisticEntity> getAll(
            @RequestParam(required = false) String entity,
            @RequestParam(required = false) String canton,
            @RequestParam(required = false) String municipality,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) String endDate
    ) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date start = startDate.isEmpty() ? null : formatter.parse(startDate);
        Date end = endDate.isEmpty() ? null : formatter.parse(endDate);
        return statisticService.getAll(new StatisticSearchRequest(entity, canton, municipality, start, end));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Valid
    public Statistic create(@Valid @RequestBody Statistic statistic) {
        return statisticService.add(statistic);
    }
}
