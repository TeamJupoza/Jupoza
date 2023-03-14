package gachon.jupoza.repository;


import gachon.jupoza.domain.PortFolio;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PortfolioRepository extends JpaRepository<PortFolio, Long> {

     PortFolio findByUserAccount_UserId(String userId);

     void deleteByUserAccount_UserId(String userId);


}
