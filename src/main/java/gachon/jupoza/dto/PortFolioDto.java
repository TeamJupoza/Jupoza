package gachon.jupoza.dto;

import gachon.jupoza.domain.PortFolio;
import gachon.jupoza.domain.Stock;
import gachon.jupoza.domain.UserAccount;
import gachon.jupoza.domain.Weights;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the {@link gachon.jupoza.domain.PortFolio} entity
 */
@Data
public class PortFolioDto {
    private final Long id;
    private final UserAccountDto userAccountDto;
    private final List<Stock> StockList;
    private final Weights weights;
    private final LocalDateTime createdAt;
    private final String createdBy;
    private final LocalDateTime modifiedAt;
    private final String modifiedBy;

    public static PortFolioDto of(Long id, UserAccountDto userAccount, List<Stock> stockList, Weights weights)
    {
        return new PortFolioDto(id,userAccount,stockList,weights,null,null,null,null);
    }
    public static PortFolioDto of(Long id, UserAccountDto userAccount, List<Stock> stockList, Weights weights,LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy)
    {
        return new PortFolioDto(id,userAccount,stockList,weights,createdAt,createdBy,modifiedAt,modifiedBy);
    }

    // entity -> dto 변환
    public  PortFolioDto from(PortFolio entity)
    {
        return new PortFolioDto(
                entity.getId(),
                UserAccountDto.from(entity.getUserAccount()),
                entity.getStockList(),
                entity.getWeights(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    // dto -> entity 변환
    public PortFolio toEntity(UserAccount userAccount)
    {
        return PortFolio.of(
                userAccount,
                (ArrayList<Stock>)StockList,
                weights
        );
    }
}