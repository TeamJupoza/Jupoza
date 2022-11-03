package gachon.jupoza.service;

import gachon.jupoza.domain.Stock;
import gachon.jupoza.domain.StockRepository;
import gachon.jupoza.domain.mapping.StockMapping;
import gachon.jupoza.dto.StockDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;


    @Transactional(readOnly = true)
    public StockDTO stockInfo (int id){
        int stockId =Integer.parseInt(String.format("%06d",id));

        Stock entity = stockRepository.findById(stockId).orElseThrow(() ->  new IllegalArgumentException("해당 사용자가 없습니다. id="+ id));

        return new StockDTO(entity);
    }

    @Transactional(readOnly = true)
    public List<StockMapping> stockByPer (){

        return stockRepository.findTop50ByOrderByPerDesc();
    }
    @Transactional(readOnly = true)
    public List<StockMapping> stockByDiv (){

        return stockRepository.findTop50ByOrderByDividendDesc();
    }
    @Transactional(readOnly = true)
    public List<StockMapping> stockByIRate (){

        return stockRepository.findTop50ByOrderByRateDesc();
    }
    @Transactional(readOnly = true)
    public List<StockMapping> stockByNet (){

        return stockRepository.findTop50ByOrderByNetDesc();
    }
    @Transactional(readOnly = true)
    public List<StockMapping> stockBySafety (){

        return stockRepository.findTop50ByOrderByScoreDesc();
    }
    @Transactional(readOnly = true)
    public List<StockMapping> stockBySales (){

        return stockRepository.findTop50ByOrderBySaleDesc();
    }

    @Transactional(readOnly = true)
    public List<StockMapping> stockByName (){

        return stockRepository.findTop50ByOrderByNameDesc();
    }


}
