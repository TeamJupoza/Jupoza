package gachon.jupoza.dto;

import gachon.jupoza.domain.Stock;
import gachon.jupoza.domain.UserAccount;
import gachon.jupoza.domain.Weights;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link gachon.jupoza.domain.PortFolio} entity
 */
@Data
public class PortFolioDto {
    private final Long id;
    private final UserAccount userAccount;
    private final List<Stock> StockList;
    private final Weights weights;

}