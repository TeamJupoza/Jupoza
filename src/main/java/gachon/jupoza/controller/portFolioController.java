package gachon.jupoza.controller;

import gachon.jupoza.repository.StockRepository;
import gachon.jupoza.dto.StockDTO;
import gachon.jupoza.service.portFolioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class portFolioController {

    private final portFolioService portFolioService;

    public portFolioController(gachon.jupoza.service.portFolioService portFolioService) {
        this.portFolioService = portFolioService;
    }

    @PostMapping("/api/portfolio")
    Map<String, Object> portfolio(@RequestBody Map<String, Object> request) {
        log.info("{}",request);
        // 요청된 주식목록
        List<String> requestStocks = new ArrayList<>();
        requestStocks = (List<String>) request.get("RequestStock");

        // DB에서 주식 데이터 가져오기
        List<StockDTO> stocks = portFolioService.getStocks(requestStocks);

        // Flask 서버에 weight 요청해서 가져오기
        Map<String, Object> weightRequest = new HashMap<>();
        weightRequest.put("weightRequest", requestStocks);

        // 종목들의 Weight 요청하기
        List<Object> weights = new ArrayList<>();
        weights = portFolioService.getWeight(weightRequest);
        // response
        Map<String, Object> result = new HashMap<>();
        result.put("stocks", stocks);
        result.put("weights",weights);
        result.put("result", "success");


        return result;
    }



}

