package com.master.covidservice.covidservice.service;

import com.master.covidservice.covidservice.domain.Article;
import com.master.covidservice.covidservice.exception.BadRequestException;
import com.master.covidservice.covidservice.exception.EntityNotFoundException;
import com.master.covidservice.covidservice.model.ArticleEntity;
import com.master.covidservice.covidservice.model.InstitutionEntity;
import com.master.covidservice.covidservice.repository.ArticleRepository;
import com.master.covidservice.covidservice.repository.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private InstitutionRepository institutionRepository;

    public List<Article> getAll() {
        return articleRepository.findAll().stream()
                .map(ArticleEntity::toExtendedDomain)
                .collect(Collectors.toList());
    }

    public Article getById(UUID id) {
        Optional<ArticleEntity> entity = articleRepository.findById(id);
        if (!entity.isPresent()) {
            throw new EntityNotFoundException(String.format("Article with id=%s does not exist.", id));
        }

        return entity.get().toExtendedDomain();
    }

    public Article add(Article article) {
        ArticleEntity entity = mapDomainToEntity(article);

        entity.setInstitution(getInstitution(article.getInstitution().getId()));

        return articleRepository.save(entity).toExtendedDomain();
    }

    public Article update(UUID id, Article article) {
        Optional<ArticleEntity> articleEntity = articleRepository.findById(id);
        if (!articleEntity.isPresent()) {
            throw new EntityNotFoundException(String.format("Article with id=%s does not exist.", id));
        }

        ArticleEntity entity = articleEntity.get();
        entity.setTitle(article.getTitle());
        entity.setDate(article.getDate());
        entity.setContent(article.getContent());
        entity.setActive(article.isActive());

        entity.setInstitution(getInstitution(article.getInstitution().getId()));

        return articleRepository.save(entity).toExtendedDomain();
    }

    public void deleteById(UUID id) {
        if (!articleRepository.existsById(id)) {
            throw new EntityNotFoundException(String.format("Article with id=%s does not exist.", id));
        }
        articleRepository.deleteById(id);
    }

    private ArticleEntity mapDomainToEntity(Article article) {
        ArticleEntity entity = new ArticleEntity();

        entity.setTitle(article.getTitle());
        entity.setDate(article.getDate());
        entity.setContent(article.getContent());
        entity.setActive(article.isActive());

        return entity;
    }

    private InstitutionEntity getInstitution(UUID id) {
        Optional<InstitutionEntity> institutionEntity = institutionRepository.findById(id);
        if (!institutionEntity.isPresent()) {
            throw new BadRequestException(String.format("Institution with id=%s does not exists.", id));
        }
        return institutionEntity.get();
    }
}
