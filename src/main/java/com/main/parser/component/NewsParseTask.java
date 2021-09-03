package com.main.parser.component;


import java.io.IOException;

import com.main.parser.model.News;
import com.main.parser.service.NewsService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Component
public class NewsParseTask {

    @Autowired
    NewsService newsService;

    @Scheduled(fixedDelay = 10000)
    public void parseNews() {
        String url = "https://oxu.az/";

        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla")
                    .timeout(5000)
                    .referrer("https://google.com")
                    .get();
            Elements news = doc.getElementsByClass("title");
            for (Element el: news) {
                String title = el.ownText();
                if (!newsService.isExist(title)) {
                    News obj = new News();
                    obj.setTitle(title);
                    newsService.save(obj);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}