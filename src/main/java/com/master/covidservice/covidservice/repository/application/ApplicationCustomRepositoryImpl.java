package com.master.covidservice.covidservice.repository.application;

import com.master.covidservice.covidservice.dto.ApplicationSearchRequest;
import com.master.covidservice.covidservice.model.ApplicationEntity;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ApplicationCustomRepositoryImpl implements ApplicationCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ApplicationEntity> search(ApplicationSearchRequest request) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ApplicationEntity> query = cb.createQuery(ApplicationEntity.class);
        Root<ApplicationEntity> resource = query.from(ApplicationEntity.class);


        List<Predicate> predicates = new ArrayList<>();

        if (request.getProcessed() != null) {
            predicates.add(cb.equal(resource.get("processed"), request.getProcessed()));
        }

        if (StringUtils.hasText(request.getName())) {
            predicates.add(cb.like(cb.lower(resource.get("name")), "%" + request.getName().toLowerCase() + "%"));
        }

        if (StringUtils.hasText(request.getSurname())) {
            predicates.add(cb.like(cb.lower(resource.get("surname")), "%" + request.getSurname().toLowerCase() + "%"));
        }

        if (StringUtils.hasText(request.getType().getLabel())) {
            predicates.add(cb.equal(resource.get("type"), request.getType()));
        }

        query
                .select(resource)
                .where(cb.and(predicates.toArray(new Predicate[predicates.size()])))
                .orderBy(cb.desc(resource.get("date")));

        return entityManager
                .createQuery(query)
                .getResultList();
    }
}
