package gachon.jupoza.controller;

import gachon.jupoza.domain.mapping.StockMapping;
import gachon.jupoza.dto.StockDTO;
import gachon.jupoza.service.CrawlingService;
import gachon.jupoza.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class StockController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final StockService stockService;
    private final CrawlingService crawlingService;

    @Autowired //readme 참고
    public StockController(StockService stockService, CrawlingService crawlingService) {
        this.stockService = stockService;
        this.crawlingService = crawlingService;
    }


    @GetMapping("/stock/img/{id}")
    public String stockImg(@PathVariable("id") int id)throws IOException {
        return crawlingService.getStockImg(id);
    }


    @GetMapping("/stock/{id}")
    public StockDTO stockInfo(@PathVariable Integer id){
        return stockService.stockInfo(id);
    }

    @GetMapping("/stock/per")
    public List<StockMapping> stockByPer(){
        return stockService.stockByPer();
    }

    @GetMapping("/stock/dividend")
    public List<StockMapping> stockByDiv(){
        return stockService.stockByDiv();
    }

    @GetMapping("/stock/irate")
    public List<StockMapping> stockByIRate(){
        return stockService.stockByIRate();
    }

    @GetMapping("/stock/net")
    public List<StockMapping> stockByNet(){
        return stockService.stockByNet();
    }

    @GetMapping("/stock/safety")
    public List<StockMapping> stockBySafety(){
        return stockService.stockBySafety();
    }

    @GetMapping("/stock/sales")
    public List<StockMapping> stockBySales(){
        return stockService.stockBySales();
    }

    @GetMapping("/stock/name")
    public List<StockMapping> stockByName(){
        return stockService.stockByName();
    }


}
