package com.yura.service;

import com.yura.dto.Content;
import com.yura.dto.LLMResponse;
import com.yura.dto.Output;
import com.yura.model.Article;
import com.yura.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final OpenAIService openAIService;

    public ArticleService(ArticleRepository articleRepository, OpenAIService openAIService) {
        this.articleRepository = articleRepository;
        this.openAIService = openAIService;
    }

    public Article generateAndSaveArticle(String seedText) {
        LLMResponse generatedContent = openAIService.generateText(seedText);
        List<Output> outputList = generatedContent.getOutput();
        Output output = generatedContent.getOutput().get(outputList.size() - 1);
        List<Content> contentList = output.getContent();
        Content content = contentList.get(contentList.size() - 1);
        String title = "Generated Title: " + seedText.substring(0, Math.min(10, seedText.length())) + "...";
        Article article = new Article(title, content.getText());
        return articleRepository.save(article);
    }

    public List<Article> findAllArticles() {
        return articleRepository.findAll();
    }
}
