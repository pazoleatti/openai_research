package com.yura.controller;

import com.yura.model.Article;
import com.yura.service.ArticleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/article")
    public Article generateArticle(@RequestParam String seedText) {
        return articleService.generateAndSaveArticle(seedText);
    }

    @GetMapping("/article")
    public List<Article> getAllArticles() {
        return articleService.findAllArticles();
    }
}
