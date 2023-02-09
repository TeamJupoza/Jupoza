package gachon.jupoza.dto;

import gachon.jupoza.domain.Stock;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StockDTO {

    private int no;
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


    @Builder
    public StockDTO (int no, Stock entity){
        this.no = no;
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

}
