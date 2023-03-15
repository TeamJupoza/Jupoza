package gachon.jupoza.service;

import gachon.jupoza.domain.PortFolio;
import gachon.jupoza.domain.Stock;
import gachon.jupoza.dto.StockDto;
import gachon.jupoza.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
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


    // 클라이언트에서 선택한 주식 종목 5개의 대한 정보를 DB에서 가져온다.
    public List<StockDto> getStocks(List<String> request)
    {

        // DB에서 요청된 주식 정보 가져오가
        List<Stock> StockEntityList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            StockEntityList.add(stockRepository.findByname(request.get(i)));
        }


        List<StockDto> stockList = new ArrayList<>();
        for (Stock stock : StockEntityList) {
            StockDto stockDTO = StockDto.builder()
                    .entity(stock)
                    .build();
            stockList.add(stockDTO);
        }

        return stockList;
    }

    // 파이썬 서버에 접속해 선택한 5개의 주식종목을 입력해 알고리즘을 거친후 종목들의 비중을 반환한다.
    public List<Object> getWeight(Map<String, Object> request) {


        URI uri = UriComponentsBuilder
                .fromUriString("http://127.0.0.1:5000")
                .path("/")
                .encode()
                .build()
                .expand(request)
                .toUri();

        HttpHeaders httpHeaders = new HttpHeaders();

        HttpEntity<Map<String, Object>> httpEntity = new HttpEntity(request, httpHeaders);


        RestTemplate rt = new RestTemplate();
        ResponseEntity<HashMap> responseEntity = rt.exchange(uri, HttpMethod.POST, httpEntity, HashMap.class);

        List<Object> result = new ArrayList<>();
        result = (List<Object>) responseEntity.getBody().get("weightResponse");

        return result;

    }


}
