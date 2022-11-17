package gachon.jupoza.service;

import gachon.jupoza.domain.Stock;
import gachon.jupoza.domain.StockRepository;
import gachon.jupoza.dto.StockDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;

    /** stockList service **/
    @Transactional(readOnly = true)
    public List<StockDTO> stockByOrder (String category) throws IOException {
        List<Stock> stocks;
        log.debug(category);
        if (Objects.equals(category, "per")){
            stocks = stockRepository.findByPerQuery();
        }
        else {
            stocks = stockRepository.findAll(Sort.by(Sort.Direction.DESC, category));
        }
        List<StockDTO> stockList = new ArrayList<>();

        int i=1;
        for(Stock stock : stocks){
            StockDTO stockDTO = StockDTO.builder()
                    .no(i)
                    .entity(stock)
                    .build();
            stockList.add(stockDTO);
            i++;
        }
        return stockList;
    }


}
