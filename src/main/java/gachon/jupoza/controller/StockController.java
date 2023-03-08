package gachon.jupoza.controller;

import gachon.jupoza.service.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class StockController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final StockService stockService;

    @Autowired //readme 참고
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }


    @PostMapping("portfolio/stock")
    public String portfolioStock(@RequestBody List<Map<String,Object>> form){

        System.out.println(form);
        return "blank3.html";
    }


    /** category별 stock list 조회
     * list/?category=(per,net,div,score,std)
     * requestParam으로 category 받음
     * default는 per
     * **/
    @GetMapping("/list")
    public String stockByCategory(@RequestParam(required = true, defaultValue = "per") String category, Model model) throws IOException {
        model.addAttribute("list", stockService.stockByOrder(category));

        return "stocklist";
    }


}
