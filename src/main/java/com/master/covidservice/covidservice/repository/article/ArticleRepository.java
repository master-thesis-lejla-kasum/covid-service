package com.master.covidservice.covidservice.repository.article;

import com.master.covidservice.covidservice.model.ArticleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ArticleRepository extends JpaRepository<ArticleEntity, UUID>, ArticleCustomRepository {
}
