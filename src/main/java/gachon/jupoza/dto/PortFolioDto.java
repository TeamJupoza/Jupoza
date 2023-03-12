package gachon.jupoza.dto;

import gachon.jupoza.domain.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the {@link gachon.jupoza.domain.PortFolio} entity
 */
@Data
public class PortFolioDto {

    private final UserAccountDto userAccountDto;
    private final List<MyStock> StockList;

    private final LocalDateTime createdAt;
    private final String createdBy;
    private final LocalDateTime modifiedAt;
    private final String modifiedBy;



    public static PortFolioDto of(UserAccountDto userAccount, List<MyStock> stockList)
    {
        return new PortFolioDto(userAccount,stockList,null,null,null,null);
    }
    public static PortFolioDto of(UserAccountDto userAccount, List<MyStock> stockList,LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy)
    {
        return new PortFolioDto(userAccount,stockList,createdAt,createdBy,modifiedAt,modifiedBy);
    }

    // entity -> dto 변환
    public static PortFolioDto from(PortFolio entity)
    {
        return new PortFolioDto(
                UserAccountDto.from(entity.getUserAccount()),
                entity.getMyStockList(),
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
                StockList
        );
    }
}