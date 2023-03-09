package gachon.jupoza.dto;

import gachon.jupoza.domain.PortFolio;
import gachon.jupoza.domain.Weights;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link gachon.jupoza.domain.Weights} entity
 */
@Data
public class WeightsDto  {
    private final Long id;
    private final float weight1;
    private final float weight2;
    private final float weight3;
    private final float weight4;
    private final float weight5;

    public static WeightsDto of(Long id, float weight1, float weight2, float weight3, float weight4, float weight5)
    {
        return new WeightsDto(id, weight1, weight2, weight3, weight4, weight5);
    }

    public  static WeightsDto from(Weights entity)
    {
        return new WeightsDto(
                entity.getId(),
                entity.getWeight1(),
                entity.getWeight2(),
                entity.getWeight3(),
                entity.getWeight4(),
                entity.getWeight5()
        );
    }

    public  Weights toEntity()
    {
        return Weights.of(
                id,
                weight1,
                weight2,
                weight3,
                weight4,
                weight5
        );
    }


}