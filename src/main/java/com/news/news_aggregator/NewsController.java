package com.news.news_aggregator;

import com.news.news_aggregator.model.Article;
import com.news.news_aggregator.model.NewsResponse;
import com.news.news_aggregator.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin(origins = "*") // Allow all origins for development
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    // Main page - Returns the professional HTML template
    @GetMapping("/")
    public String index(Model model) {
        return "news"; // This will load news.html from templates folder
    }

    // API Endpoint - Returns JSON for AJAX calls (keep your original)
    @GetMapping("/news")
    @ResponseBody
    public NewsResponse getTopHeadlinesAsObject() {
        return newsService.getTopHeadlinesAsObject();
    }

    // Legacy HTML endpoint (keep your original for backward compatibility)
    @GetMapping("/news/html")
    @ResponseBody
    public String getNewsAsHtml() {
        NewsResponse response = newsService.getTopHeadlinesAsObject();
        StringBuilder html = new StringBuilder("<html><body>");
        html.append("<h1>Top Headlines</h1>");

        if (response != null && response.getArticles() != null) {
            for (Article article : response.getArticles()) {
                html.append("<div style='margin-bottom:20px;'>")
                    .append("<h3><a href='").append(article.getUrl()).append("'>")
                    .append(article.getTitle()).append("</a></h3>");
                if (article.getUrlToImage() != null) {
                    html.append("<img src='").append(article.getUrlToImage())
                        .append("' alt='Image' style='max-width:400px;'><br>");
                }
                html.append("<p>").append(article.getDescription() != null ? article.getDescription() : "")
                    .append("</p></div>");
            }
        }

        html.append("</body></html>");
        return html.toString();
    }

    // Additional endpoint for search functionality (optional enhancement)
    @GetMapping("/news/search")
    @ResponseBody
    public NewsResponse searchNews(String query) {
        // You can implement search logic here later
        return newsService.getTopHeadlinesAsObject();
    }
}