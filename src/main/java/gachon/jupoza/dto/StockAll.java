package gachon.jupoza.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StockAll {

    private int stockId;
    private String name;
    private int price;
    private float per;
    private float roe;
    private float dividend;
    private float increaseRate;
    private float netProfit;
    private float bis;
    private float current;
    private float quick;
    private float debt;
    private float score;
    private float sales;
    private float std;

    @Builder
    public StockAll (Integer no, String name, Integer price, float per, float roe, float dividend, float bis, float current, float quick, float debt, float score, float sales, float std, float increaseRate, float netProfit){
        this.stockId = getStockId();
        this.name = getName();
        this.price = getPrice();
        this.per = getPer();
        this.roe = getRoe();
        this.dividend = getDividend();
        this.increaseRate = getIncreaseRate();
        this.netProfit = getNetProfit();
        this.bis = getBis();
        this.current = getCurrent();
        this.quick = getQuick();
        this.debt = getDebt();
        this.score = getScore();
        this.sales = getSales();
        this.std = getStd();
    }
}
