package com.master.covidservice.covidservice.repository.statistic;

import com.master.covidservice.covidservice.dto.StatisticSearchRequest;
import com.master.covidservice.covidservice.model.ApplicationEntity;
import com.master.covidservice.covidservice.model.CustomStatisticEntity;
import com.master.covidservice.covidservice.model.StatisticEntity;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StatisticCustomRepositoryImpl implements StatisticCustomRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<CustomStatisticEntity> search(StatisticSearchRequest request) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<CustomStatisticEntity> query = cb.createQuery(CustomStatisticEntity.class);
        Root<StatisticEntity> resource = query.from(StatisticEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.hasText(request.getEntity())) {
            predicates.add(cb.equal(resource.get("institution").get("entity"), request.getEntity()));
        }

        if (StringUtils.hasText(request.getCanton())) {
            predicates.add(cb.equal(resource.get("institution").get("canton"), request.getCanton()));
        }

        if (StringUtils.hasText(request.getMunicipality())) {
            predicates.add(cb.equal(resource.get("institution").get("municipality"), request.getMunicipality()));
        }

        if(request.getStartDate() != null) {
            predicates.add(cb.greaterThanOrEqualTo(resource.get("date"), request.getStartDate()));
        }

        if(request.getEndDate() != null) {
            predicates.add(cb.lessThanOrEqualTo(resource.get("date"), request.getEndDate()));
        }
        cb.sum(resource.get("testedCases"));

        query
                .multiselect(
                        resource.get("date").alias("date"),
                        cb.sum(resource.get("testedCases")).alias("testedCases"),
                        cb.sum(resource.get("positiveCases")).alias("positiveCases"),
                        cb.sum(resource.get("recoverCases")).alias("recoverCases"),
                        cb.sum(resource.get("deathCases")).alias("deathCases"),
                        cb.sum(resource.get("hospitalizedCases")).alias("hospitalizedCases"),
                        cb.sum(resource.get("vaccinatedCases")).alias("vaccinatedCases")
                        )
                .where(cb.and(predicates.toArray(new Predicate[predicates.size()])))
                .groupBy(resource.get("date"))
                .orderBy(cb.asc(resource.get("date")));

        return entityManager
                .createQuery(query)
                .getResultList();
    }
}
