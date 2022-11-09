package gachon.jupoza.service;

import gachon.jupoza.domain.Stock;
import gachon.jupoza.domain.StockRepository;
import gachon.jupoza.dto.StockDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    /** stockList service **/
    @Transactional(readOnly = true)
    public List<StockDTO> stockByPer (String category) throws IOException {
        List<Stock> stocks = stockRepository.findAll(Sort.by(Sort.Direction.DESC, category));
        List<StockDTO> stockList = new ArrayList<>();

        for(Stock stock : stocks){
            StockDTO stockDTO = StockDTO.builder()
                    .entity(stock)
                    .build();
            stockList.add(stockDTO);
        }
        return stockList;
    }


}
