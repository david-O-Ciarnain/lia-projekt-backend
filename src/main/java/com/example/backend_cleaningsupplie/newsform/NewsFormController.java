package com.example.backend_cleaningsupplie.newsform;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "newsform")
public class NewsFormController {

    private final NewsFormService newsFormService;

    @GetMapping(path = "news")
    public List<NewsForm> getAllNews(String title) {
        return newsFormService.getAllNews(title);
    }
    @PostMapping(path = "saveNews")
    public NewsForm saveNews(@RequestBody NewsForm newsForm){
       return newsFormService.saveNews(newsForm);
    }
    @DeleteMapping(path = "deleteNews/{title}")
    public void deleteNews( @PathVariable String title){
        newsFormService.deleteNewsMyTitle(title);
    }
    @PutMapping(path = "updateNews/{title}")
    public NewsForm updateNews(@RequestBody NewsForm newsForm, @PathVariable String title){
        return newsFormService.updateNews(newsForm,title);
    }

}
