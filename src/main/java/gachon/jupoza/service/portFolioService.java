package gachon.jupoza.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import gachon.jupoza.domain.Stock;
import gachon.jupoza.domain.StockRepository;
import gachon.jupoza.dto.StockDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class portFolioService {


    private final StockRepository stockRepository;


    public List<StockDTO> getStocks(List<String> request)
    {
        // 요청된 주식 목록 가져고기
        List<String> stocks = new ArrayList<>();
        for (int i=0;i<5;i++)
        {
            stocks.add(request.get(i));
        }
        System.out.println("stocks" +stocks);

        // DB에서 요청된 주식 정보 가져오가
        List<Stock> StockEntityList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            StockEntityList.add(stockRepository.findByname(stocks.get(i)));
        }
        System.out.println("StockEntityList : " + StockEntityList);

        List<StockDTO> stockList = new ArrayList<>();
        for (Stock stock : StockEntityList) {
            StockDTO stockDTO = StockDTO.builder()
                    .entity(stock)
                    .build();
            stockList.add(stockDTO);
        }

        return stockList;


    }

    public List<Object> getWeight(Map<String, Object> request) {


        URI uri = UriComponentsBuilder
                .fromUriString("http://127.0.0.1:5000")
                .path("/")
                .encode()
                .build()
                .expand(request)
                .toUri();
        log.info("uri : {}", uri);

        HttpHeaders httpHeaders = new HttpHeaders();

        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity(request, httpHeaders);


        RestTemplate rt = new RestTemplate();
        ResponseEntity<HashMap> responseEntity = rt.exchange(uri, HttpMethod.POST, httpEntity, HashMap.class);
        responseEntity.getHeaders().forEach((k, v) -> System.out.println(k + " " + v));
        responseEntity.getBody().forEach((k, v) -> System.out.println(k + " " + v));

        List<Object> result = new ArrayList<>();
        result = (List<Object>) responseEntity.getBody().get("weightResponse");

        return result;

    }



}
