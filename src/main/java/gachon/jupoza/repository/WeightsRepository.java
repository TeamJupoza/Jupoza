package gachon.jupoza.repository;

import gachon.jupoza.domain.Weights;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeightsRepository extends JpaRepository<Weights, Long> {
}
