package gachon.jupoza.controller;

import gachon.jupoza.domain.Stock;
import gachon.jupoza.domain.StockRepository;
import gachon.jupoza.dto.StockDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class portFolioController {

    @Autowired
    StockRepository stockRepository;
    @PostMapping("/api/portfolio")
    Map<String, Object> portfolio ()
    {
        List<Stock> stocks = new ArrayList<>();
        stocks = stockRepository.findAll();

        List<StockDTO> stockList = new ArrayList<>();

        for(Stock stock : stocks){
            StockDTO stockDTO = StockDTO.builder()
                    .entity(stock)
                    .build();
            stockList.add(stockDTO);
        }
        Map<String, Object> result = new HashMap<>();
        result.put("stocks", stockList);
        result.put("result","success");
        System.out.println(result);
        return result;
    }

}
