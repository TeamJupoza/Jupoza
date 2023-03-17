package gachon.jupoza.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Entity
@AllArgsConstructor
@DynamicUpdate
@ToString
public class ArticleStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JsonBackReference
    @Setter
    @ToString.Exclude
    private Article article;

    int stockId;

    float weight;


    @Setter
    String userId;
    public ArticleStock() {

    }

    public ArticleStock(int stockId, float weight) {
        this.stockId = stockId;
        this.weight = weight;
    }


    public ArticleStock(int stockId, float weight, String userId) {
        this.stockId = stockId;
        this.weight = weight;
        this.userId = userId;
    }

    public ArticleStock(Article article, int stockId, float weight, String userId) {
        this.article = article;
        this.stockId = stockId;
        this.weight = weight;
        this.userId = userId;
    }

    public static ArticleStock of(int stockId, float weight) {
        return new ArticleStock(stockId,weight);
    }


    public static ArticleStock of(int stockId, float weight, String UserId) {
        return new ArticleStock(stockId,weight,UserId);
    }

    public static ArticleStock of (Article article, int stockId, float weight, String userId) {
        return new ArticleStock(article,stockId,weight,userId);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArticleStock)) return false;
        ArticleStock myStock = (ArticleStock) o;
        return id.equals(myStock.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
