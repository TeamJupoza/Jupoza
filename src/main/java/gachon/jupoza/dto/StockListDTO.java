package gachon.jupoza.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class StockListDTO {
    private Integer no;
    private String name;
    private int price;

    @Builder
    public StockListDTO(Integer no, String name, Integer price){
        this.no = no;
        this.name = name;
        this.price = price;
    }
}
