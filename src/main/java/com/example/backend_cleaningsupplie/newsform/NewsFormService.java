package com.example.backend_cleaningsupplie.newsform;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class NewsFormService {

    private final NewsFormRepo newsFormRepo;

    public List<NewsForm> getAllNews(String title) {
        checkIfTitleExist(title);
        return newsFormRepo.findAll();
    }

    public NewsForm saveNews(NewsForm newsForm) {
        if (newsForm == null || newsForm.getTitle().isEmpty() || newsForm.getTitle().isBlank()) {
            throw new IllegalStateException("there is no new news");
        }
        return newsFormRepo.save(newsForm);
    }

    public void deleteNewsMyTitle(String title) {
        checkIfTitleExist(title);
        newsFormRepo.deleteByTitle(title);
    }

    public NewsForm updateNews(NewsForm newsForm, String title) {

        checkIfTitleExist(title);
        return newsFormRepo.findByTitle(title)
                .map(news -> {
                    news.setTitle(newsForm.getTitle());
                    news.setFulltext(newsForm.getFulltext());
                    return newsFormRepo.save(news);
                })
                .orElseGet(() -> {
                    newsForm.setTitle(title);
                    return newsFormRepo.save(newsForm);
                });
    }


    public void checkIfTitleExist(String title) {
        boolean exits = newsFormRepo.existsByTitle(title);
        if (!exits) {
            throw new IllegalStateException("Title on news do not exists");
        }

    }
}
