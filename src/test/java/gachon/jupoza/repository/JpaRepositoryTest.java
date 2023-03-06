package gachon.jupoza.repository;

import gachon.jupoza.domain.Stock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("JPA 연결 테스트")
@SpringBootTest
class JpaRepositoryTest {

    private StockRepository stockRepository;

    public JpaRepositoryTest(@Autowired StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
    

    void given_when_then()
    {
        // given

        // when

        // then
    }

    @DisplayName("select 테스트")
    @Test
    void givenTestData_whenSelecting_thenWorksFine()
    {
        // given

        // when
        List<Stock> stockList = stockRepository.findAll();
        // then
        assertThat(stockList)
                .isNotNull();
    }

    @DisplayName("insert 테스트")
    @Test
    void givenTestData_whenInserting_thenWorksFine()
    {
        // given
        long previousCount = stockRepository.count();
        // when
        Stock stock = stockRepository.findById(60).orElseThrow();
        stock.setName("test");
        stock.setStockId(1);
        Stock savedStock = stockRepository.save(stock);

        // then
        assertThat(stockRepository.count()).isEqualTo(previousCount + 1);
    }

    @DisplayName("update 테스트")
    @Test
    void givenTestData_whenUpdating_thenWorksFine()
    {
        // given
        Stock stock = stockRepository.findById(60).orElseThrow();
        String updatingName = "test";
        stock.setName(updatingName);

        // when
        Stock savedStock = stockRepository.saveAndFlush(stock);
        // then
        assertThat(savedStock).hasFieldOrPropertyWithValue("name", "test");
    }







}
