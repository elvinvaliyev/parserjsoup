package com.main.parser.service;

import com.main.parser.model.News;
import com.main.parser.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService{

    @Autowired
    NewsRepository newsRepository;

    @Override
    public void save(News news) {
        newsRepository.save(news);

    }

    @Override
    public boolean isExist(String newsTitle) {
        List<News> allNews = newsRepository.findAll();
        for (News n: allNews) {
            if (n.getTitle().equals(newsTitle)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }
}
