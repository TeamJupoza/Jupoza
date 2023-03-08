package gachon.jupoza.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link gachon.jupoza.domain.Weights} entity
 */
@Data
public class WeightsDto implements Serializable {
    private final Long id;
    private final float weight1;
    private final float weight2;
    private final float weight3;
    private final float weight4;
    private final float weight5;
}