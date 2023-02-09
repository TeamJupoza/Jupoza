package gachon.jupoza.repository;

import gachon.jupoza.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
    Stock findByname(String name);


    @Query("select s from Stock s WHERE s.roe >= 10 AND s.per >= 0 ORDER BY s.per")
    List<Stock> findByPerQuery();
}

