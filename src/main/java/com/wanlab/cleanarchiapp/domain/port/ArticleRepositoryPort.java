package com.wanlab.cleanarchiapp.domain.port;

import com.wanlab.cleanarchiapp.domain.entities.Article;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ArticleRepositoryPort {

    Article save(Article article);

    Optional<Article> findById(UUID id);

    void deleteById(UUID id);

    List<Article> findAll();

    Article update(UUID id, Article article);
}
