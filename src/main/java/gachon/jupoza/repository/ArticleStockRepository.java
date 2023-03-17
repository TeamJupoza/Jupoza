package gachon.jupoza.repository;

import gachon.jupoza.domain.ArticleStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleStockRepository extends JpaRepository<ArticleStock, Long>
{

    void deleteByArticleId(Long articleId);
}
