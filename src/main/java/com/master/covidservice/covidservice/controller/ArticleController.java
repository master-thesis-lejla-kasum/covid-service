package com.master.covidservice.covidservice.controller;


import com.master.covidservice.covidservice.domain.Article;
import com.master.covidservice.covidservice.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping
    public List<Article> getAll() {
        return articleService.getAll();
    }

    @GetMapping("/{id}")
    public Article getById(@PathVariable UUID id) {
        return articleService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Valid
    public Article create(@Valid @RequestBody Article role) {
        return articleService.add(role);
    }

    @PutMapping("/{id}")
    @Valid
    public Article update(@PathVariable UUID id, @Valid @RequestBody Article role) {
        return articleService.update(id, role);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        articleService.deleteById(id);
    }
}
