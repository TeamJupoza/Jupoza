package gachon.jupoza.domain;

import gachon.jupoza.domain.mapping.StockMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Integer> {

    List<StockMapping> findTop50ByOrderByNameDesc();

    List<StockMapping> findTop50ByOrderByPerDesc();
    List<StockMapping> findTop50ByOrderByDividendDesc();
    List<StockMapping> findTop50ByOrderByRateDesc();

    List<StockMapping> findTop50ByOrderByScoreDesc();

    List<StockMapping> findTop50ByOrderBySaleDesc();
    List<StockMapping> findTop50ByOrderByNetDesc();




}

