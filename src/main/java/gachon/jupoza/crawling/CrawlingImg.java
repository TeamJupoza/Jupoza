package gachon.jupoza.crawling;

import gachon.jupoza.domain.Stock;
import gachon.jupoza.domain.StockRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class CrawlingImg implements CommandLineRunner {
    private final StockRepository stockRepository;

    public CrawlingImg(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        List<Stock> stockList = stockRepository.findAll();


        for (Stock stock : stockList) {
            Stock entity = stockRepository.findById(stock.getStockId())
                    .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + stock.getStockId()));
            String stockId = String.format("%06d", stock.getStockId());
            String STOCK_IMAGE_URL = "https://finance.naver.com/item/main.naver?code=" + stockId;

            Document doc = Jsoup.connect(STOCK_IMAGE_URL).get();
            Elements elem = doc.select("#img_chart_area");
            String text = elem.attr("src");

            entity.update(text);
        }
    }
}
