package gachon.jupoza.dto;

import gachon.jupoza.domain.Stock;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StockDTO {

    private int stockId;
    private String name;
    private int price;
    private float per;
    private float roe;
    private float dividend;  //매출
    private float rate;  //연간주식상승률
    private float net; //순이익 상승률
    private float bis;  //자기자본비율
    private float current;  //유동비율
    private float quick;  //당좌비율
    private float debt;  //부채비율
    private float score;  //계산점수
    private float sale;  //배당률
    private float std;  //표준편차
    private String img;



/*    public Stock toEntity(){
        Stock build = Stock.builder()
                .stockId(stockId)
                .price(price)
                .name(name)
                .per(per)
                .roe(roe)
                .dividend(dividend)
                .rate(rate)
                .net(net)
                .bis(bis)
                .current(current)
                .quick(quick)
                .debt(debt)
                .score(score)
                .sale(sale)
                .std(std)
                .build();
        return build;
    }*/

    @Builder
    public StockDTO (Stock entity){
        this.stockId = entity.getStockId();
        this.name = entity.getName();
        this.price = entity.getPrice();
        this.per = entity.getPer();
        this.roe = entity.getRoe();
        this.dividend = entity.getDividend();
        this.rate = entity.getRate();
        this.net = entity.getNet();
        this.bis = entity.getBis();
        this.current = entity.getCurrent();
        this.quick = entity.getQuick();
        this.debt = entity.getDebt();
        this.score = entity.getScore();
        this.sale = entity.getSale();
        this.std = entity.getStd();
        this.img = entity.getImg();
    }
/*    @Builder
    public StockDTO (Integer stockId, String name, Integer price, float per, float roe, float dividend, float bis, float current, float quick, float debt, float score, float sale, float std, float rate, float net, String chart){
        this.stockId = stockId;
        this.name = name;
        this.price = price;
        this.per = per;
        this.roe = roe;
        this.dividend = dividend;
        this.rate = rate;
        this.net = net;
        this.bis = bis;
        this.current = current;
        this.quick = quick;
        this.debt = debt;
        this.score = score;
        this.sale = sale;
        this.std = std;
        this.chart = chart;
    }*/
}
