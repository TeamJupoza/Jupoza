package gachon.jupoza.dto;

import gachon.jupoza.domain.MyStock;
import lombok.Data;

@Data
public class MyStockDto {

    private final int StockId;

    private final float weight;


    public MyStock of(int stockId, float weight)
    {
        return new MyStock(stockId,weight);
    }

}
