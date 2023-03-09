package gachon.jupoza.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StockListDto {
    private Integer stockId;
    private String name;
    private int price;

    @Builder
    public StockListDto(Integer stockId, String name, Integer price) {
        this.stockId = stockId;
        this.name = name;
        this.price = price;
    }
}