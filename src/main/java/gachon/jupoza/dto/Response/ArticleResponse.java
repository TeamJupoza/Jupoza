package gachon.jupoza.dto.Response;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ArticleResponse {

    String articleId;

    String title;

    String createdBy;

    String createdAt;



    public static ArticleResponse of(String articleId, String title, String createdBy, String createdAt) {
        return new ArticleResponse(articleId,title,createdBy,createdAt);
    }
}

