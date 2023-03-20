package gachon.jupoza.dto;

import gachon.jupoza.domain.Article;
import gachon.jupoza.domain.ArticleStock;
import gachon.jupoza.domain.UserAccount;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class ArticleDto {
    String title;

    String content;

    List<ArticleStock> articleStockList = new ArrayList<>();


    public static ArticleDto of(String title, String content, List<ArticleStock> articleStockList) {
        return new ArticleDto(title,content,articleStockList);
    }

    public Article toEntity(UserAccount userAccount)
    {
        Article article = Article.of(userAccount, title, content, articleStockList);

        // articleStock 엔티티에 userId정보와 Article 정보를 저장
        for (ArticleStock articleStock: articleStockList
             ) {
            articleStock.setUserId(userAccount.getUserId());
            articleStock.setArticle(article);

        }
        return article;
    }


}
