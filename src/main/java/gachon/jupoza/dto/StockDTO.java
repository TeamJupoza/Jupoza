package gachon.jupoza.dto;

import gachon.jupoza.domain.Stock;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StockDTO {

    private int stockId;
    private String name;
    private int price;
    private float per;
    private float dividend;
    private float increaseRate;
    private float netProfit;
    private float safety;
    private float sales;
    private float std;

    public StockDTO (Stock entity){
        this.stockId = getStockId();
        this.name = getName();
        this.price = getPrice();
        this.per = getPer();
        this.dividend = getDividend();
        this.increaseRate = getIncreaseRate();
        this.netProfit = getNetProfit();
        this.safety = getSafety();
        this.sales = getSales();
        this.std = getStd();
    }
}
