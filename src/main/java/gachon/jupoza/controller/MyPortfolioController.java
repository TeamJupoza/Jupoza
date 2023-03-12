package gachon.jupoza.controller;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import gachon.jupoza.domain.Stock;
import gachon.jupoza.dto.PortFolioDto;
import gachon.jupoza.dto.Request.PortfolioRequest;
import gachon.jupoza.dto.UserAccountDto;
import gachon.jupoza.service.MyPortfolioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/myportfolio")
public class MyPortfolioController {

    private final MyPortfolioService myPortfolioService;

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

    // 내 포트폴리오 정보 삭제

    // 내 포트폴리오 정보 수정
}
