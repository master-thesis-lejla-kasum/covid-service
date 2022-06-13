package com.master.covidservice.covidservice.repository.article;

import com.master.covidservice.covidservice.dto.ArticleSearchRequest;
import com.master.covidservice.covidservice.model.ArticleEntity;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ArticleCustomRepositoryImpl implements ArticleCustomRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ArticleEntity> search(ArticleSearchRequest request) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ArticleEntity> query = cb.createQuery(ArticleEntity.class);
        Root<ArticleEntity> resource = query.from(ArticleEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.hasText(request.getEntity())) {
            predicates.add(cb.equal(resource.get("institution").get("entity"), request.getEntity()));
        }
        if (StringUtils.hasText(request.getCanton())) {
            predicates.add(cb.equal(resource.get("institution").get("canton"), request.getCanton()));
        }

        query
                .select(resource)
                .where(cb.and(predicates.toArray(new Predicate[predicates.size()])))
                .orderBy(cb.desc(resource.get("date")));

        return entityManager
                .createQuery(query)
                .setFirstResult(request.getPageNumber() * request.getPageSize())
                .setMaxResults(request.getPageSize())
                .getResultList();
    }

    @Override
    public int getTotalForSearch(ArticleSearchRequest request) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ArticleEntity> query = cb.createQuery(ArticleEntity.class);
        Root<ArticleEntity> resource = query.from(ArticleEntity.class);

        List<Predicate> predicates = new ArrayList<>();

        if (StringUtils.hasText(request.getEntity())) {
            predicates.add(cb.equal(resource.get("institution").get("entity"), request.getEntity()));
        }
        if (StringUtils.hasText(request.getCanton())) {
            predicates.add(cb.equal(resource.get("institution").get("canton"), request.getCanton()));
        }

        query
                .select(resource)
                .where(cb.and(predicates.toArray(new Predicate[predicates.size()])))
                .orderBy(cb.desc(resource.get("date")));

        return entityManager
                .createQuery(query)
                .getResultList()
                .size();
    }
}
