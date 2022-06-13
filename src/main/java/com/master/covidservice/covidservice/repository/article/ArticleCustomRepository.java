package com.master.covidservice.covidservice.repository.article;

import com.master.covidservice.covidservice.dto.ArticleSearchRequest;
import com.master.covidservice.covidservice.model.ArticleEntity;

import java.util.List;

public interface ArticleCustomRepository {

    List<ArticleEntity> search(ArticleSearchRequest request);

    int getTotalForSearch(ArticleSearchRequest request);
}
