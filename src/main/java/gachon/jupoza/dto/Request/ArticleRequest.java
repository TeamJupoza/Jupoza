package gachon.jupoza.dto.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import gachon.jupoza.domain.ArticleStock;
import gachon.jupoza.dto.ArticleDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ArticleRequest {

    @JsonProperty
    private String title;
    @JsonProperty
    private String userId;

    @JsonProperty
    private String content;

    private List<ArticleStock> articleStockList = new ArrayList<>();

    public static ArticleRequest of(String title,String userId, String content, List<ArticleStock> articleStockList) {
        return new ArticleRequest(title,userId, content,articleStockList);
    }

    public ArticleRequest(String title, String userId, String content) {
        this.title = title;
        this.userId = userId;
        this.content = content;
    }

    public static ArticleRequest of(String title, String userId, String content) {
        return new ArticleRequest(title,userId,content);
    }

    public ArticleDto toDto()
    {
        return ArticleDto.of(this.title, this.content, this.articleStockList);
    }
}
