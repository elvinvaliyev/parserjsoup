package com.main.parser.service;

import com.main.parser.model.News;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewsService {

    public void save(News news);
    public boolean isExist(String newsTitle);
    public List<News> getAllNews();
}
