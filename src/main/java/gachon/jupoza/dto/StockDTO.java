package gachon.jupoza.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link gachon.jupoza.domain.Stock} entity
 */
@Data
public class StockDto implements Serializable {
    private final int stockId;
    private final String name;
    private final int price;
    private final float per;
    private final float roe;
    private final float dividend;
    private final float rate;
    private final float net;
    private final float bis;
    private final float current;
    private final float quick;
    private final float debt;
    private final float score;
    private final float sale;
    private final float std;
    private final String img;
}