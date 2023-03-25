package gachon.jupoza.dto.Request;


import gachon.jupoza.domain.MyStock;
import gachon.jupoza.domain.Stock;
import gachon.jupoza.dto.PortFolioDto;
import gachon.jupoza.dto.UserAccountDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class PortfolioRequest {

    List<Stock> stockList;

    float[] weights;

    String userId;


    public static PortfolioRequest of(List<Stock> stockList, float[] weights, String userId)
    {
        return new PortfolioRequest(stockList, weights, userId);
    }

    public PortFolioDto toDto(UserAccountDto userAccountDto)
    {
        List<MyStock> myStockList = new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            myStockList.add(new MyStock(stockList.get(i).getStockId(), weights[i]));
        }
        System.out.println(myStockList.toString());


        return PortFolioDto.of(
                userAccountDto,
                myStockList
                );
    }

}
