package gachon.jupoza.repository;

import gachon.jupoza.domain.MyStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyStockRepository extends JpaRepository<MyStock, Long> {
}
