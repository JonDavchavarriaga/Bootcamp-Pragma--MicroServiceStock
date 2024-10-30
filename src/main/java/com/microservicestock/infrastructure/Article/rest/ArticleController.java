package com.microservicestock.infrastructure.Article.rest;

import com.microservicestock.application.Article.dto.ArticleDto;
import com.microservicestock.application.Article.handler.IArticleHandler;
import com.microservicestock.domain.article.model.PaginatedResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Article")
public class ArticleController {
    private final IArticleHandler articleHandler;

    public ArticleController(IArticleHandler articleHandler) {
        this.articleHandler = articleHandler;
    }
    @PostMapping
    public ResponseEntity<Void> saveCategory(@RequestBody ArticleDto articleDto) {
        articleHandler.saveArticle(articleDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public PaginatedResult<ArticleDto> getArticles( @RequestParam int page,
                                                    @RequestParam int size,
                                                    @RequestParam String sortBy,
                                                    @RequestParam boolean ascending) {
        return articleHandler.getAllArticles(page, size, sortBy, ascending);
    }




}
