package gachon.jupoza.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CrawlingService {

    //public int stockId;
    private String STOCK_IMAGE_URL = "https://finance.naver.com/item/main.naver?code=";


    public String getStockImg(int stockId) throws IOException {
        String id = String.format("%06d",stockId);
        //String STOCK_IMAGE_URL = "https://finance.naver.com/item/main.naver?code="+id;

        Document doc = Jsoup.connect(STOCK_IMAGE_URL+id).get();
        Elements elem = doc.select("#img_chart_area");
        String text = elem.attr("src");
        return text;
        }

    }
