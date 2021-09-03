package com.main.parser;

import java.util.List;

import com.main.parser.model.News;
import com.main.parser.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController {

    @Autowired
    NewsService newsService;

    @GetMapping(value = "/news")
    public List<News> getNews() {
        return newsService.getAllNews();
    }
}