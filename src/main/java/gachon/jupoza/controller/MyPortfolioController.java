package gachon.jupoza.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import gachon.jupoza.domain.PortFolio;
import gachon.jupoza.domain.Stock;
import gachon.jupoza.dto.PortFolioDto;
import gachon.jupoza.dto.Request.PortfolioRequest;
import gachon.jupoza.dto.UserAccountDto;
import gachon.jupoza.repository.StockRepository;
import gachon.jupoza.service.MyPortfolioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/myportfolio")
public class MyPortfolioController {

    private final MyPortfolioService myPortfolioService;

    private final StockRepository stockRepository;

    // 내 DB에 포트폴리오 정보를 저장
    @PostMapping("/save")
    public Map<String,Object> SavePortFolio( @RequestBody PortfolioRequest portfolioRequest) throws IOException {
        System.out.println(portfolioRequest.getClass().getName());

        log.info("portfolioRequest : {}",portfolioRequest.toString());

        //TODO: 사용자 인증 정보를 만들어야함
        UserAccountDto userAccountDto = UserAccountDto.of("minsang","minsang","minsang@naver.com","GangHal","memo");
        PortFolioDto portFolioDto = portfolioRequest.toDto(userAccountDto);

        myPortfolioService.savePortfolio(portFolioDto);

        Map<String,Object> result = new HashMap<>();
        result.put("result","success");

        return result;

    }

    // 내 포트폴리오 정보 출력
    @PostMapping("/print")
    public Map<String,Object> GetMyPortFolio(@RequestBody Map<String,Object> request) throws JsonProcessingException {
        log.info("{}",request);

        String userId = String.valueOf(request.get("userId"));

        // userId 를 이용해서 내 포트폴리오 정보를 가져옴
        PortFolio portFolio = myPortfolioService.getPortfolio(userId);
        log.info(portFolio.toString());


        // 내 포트폴리오 정보를 이용해 stock들의 정보를 가져옴
        List<Stock> stockList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            stockList.add(myPortfolioService.getStock(portFolio.getMyStockList().get(i).getStockId()));

        }
        log.info(stockList.toString());

        // Map을 통해 출력한 결과를 클라이언트로 전송
        Map<String,Object> result = new HashMap<>();
        result.put("result","success");
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());


        result.put("portFolio",objectMapper.writeValueAsString(portFolio));
        result.put("stockList",objectMapper.writeValueAsString(stockList));

        System.out.println(result);
        return result;

    }


    // 내 포트폴리오 정보 수정
    @PostMapping("/update")
    public Map<String,Object> GetMyPortFolio( @RequestBody PortfolioRequest portfolioRequest) throws JsonProcessingException {

        UserAccountDto userAccountDto = UserAccountDto.of("minsang","minsang","minsang@naver.com","GangHal","memo");
        PortFolioDto portFolioDto = portfolioRequest.toDto(userAccountDto);

        myPortfolioService.updatePortfolio(userAccountDto.getUserId(), portFolioDto);


        Map<String,Object> result = new HashMap<>();
        result.put("result","success");

        return result;

    }

    
    // 내 포트폴리오 정보 삭제
    @PostMapping("/delete")

    public Map<String,Object> deleteMyPortFolio(@RequestBody Map<String,Object> request)
    {
        String userId = String.valueOf(request.get("userId"));

        myPortfolioService.DeletePortFolio(userId);

        Map<String,Object> result = new HashMap<>();
        result.put("result","success");

        return result;

    }
}
