package gachon.jupoza.service;


import gachon.jupoza.domain.PortFolio;
import gachon.jupoza.domain.Stock;
import gachon.jupoza.domain.Weights;
import gachon.jupoza.dto.PortFolioDto;
import gachon.jupoza.dto.WeightsDto;
import gachon.jupoza.repository.PortfolioRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@DisplayName("비즈니스 로직 - 내 포트폴리오 정보")
@ExtendWith(MockitoExtension.class)
class MyPortfolioServiceTest {

    @InjectMocks private MyPortfolioService sut;

    @Mock private PortfolioRepository portfolioRepository;

    // 내 DB에 포트폴리오 정보를 저장
    @DisplayName("[service] 내 포트폴리오에 포트폴리오 정보를 저장한다.")
    @Test
    void givenPortfolioInfo_whenSavingPortfolioInfo_thenSaveMyPortfolio()
    {
        // given
        PortFolioDto dto = createPortfolioDto();
        given(portfolioRepository.save(any(PortFolio.class))).willReturn(createPortfolio());

        // when
        sut.savePortfolio(dto);

        // then
        then(portfolioRepository).should().save(any(PortFolio.class));
    }

    // 내 포트폴리오 정보를 출력
    @DisplayName("[service] 내 포트폴리오에 포트폴리오 정보를 출력한다.")
    @Test
    void givenPortfolioId_whenSearchingPortfolio_thenReturnPortfolio()
    {
        // given
        Long portfolioId = 1L;
        PortFolio portFolio = createPortfolio();
        given(portfolioRepository.findById(portfolioId)).willReturn(Optional.of(portFolio));

        // when
        PortFolioDto dto = sut.getPortfolio(portfolioId);

        // then
        assertThat(dto).
                hasFieldOrPropertyWithValue("stockList", portFolio.getStockList())
                .hasFieldOrPropertyWithValue("weights",portFolio.getWeights());
        then(portfolioRepository).should().findById(portfolioId);
    }

    // 내 포트폴리오 정보를 수정
    @DisplayName("[service] 내 포트폴리오에 포트폴리오 정보를 수정한다.")
    @Test
    void givenModifiedPortfolioInfo_whenUpdatingPortfolio_thenUpdatesPortfolio()
    {
        // given

        PortFolio portFolio = createPortfolio();
        PortFolioDto dto = createPortfolioDto();

        given(portfolioRepository.findById(portfolioId)).willReturn(Optional.of(portFolio));

        // when
        PortFolioDto dto = sut.getPortfolio(portfolioId);

        // then
        assertThat(dto).
                hasFieldOrPropertyWithValue("stockList", portFolio.getStockList())
                .hasFieldOrPropertyWithValue("weights",portFolio.getWeights());
        then(portfolioRepository).should().findById(portfolioId);
    }

    // 내 포트폴리오 정보를 삭제
    private PortFolio createPortfolio() {
        PortFolio portFolio = PortFolio.of(
                List.of(
                        new Stock(1, "TEST1", 249000, 3.62, 39.67, 302.42, 32.0793, 6.83, 59.91, 221.13, 85.65, 66.9, 5, 0.0200477, 2.56, "https://ssl.pstatic.net/imgfinance/chart/item/area/day/005490.png?sidcode=1668661888308"),
                        new Stock(2, "TEST2", 249000, 3.62, 39.67, 302.42, 32.0793, 6.83, 59.91, 221.13, 85.65, 66.9, 5, 0.0200477, 2.56, "https://ssl.pstatic.net/imgfinance/chart/item/area/day/005490.png?sidcode=1668661888308"),
                        new Stock(3, "TEST3", 249000, 3.62, 39.67, 302.42, 32.0793, 6.83, 59.91, 221.13, 85.65, 66.9, 5, 0.0200477, 2.56, "https://ssl.pstatic.net/imgfinance/chart/item/area/day/005490.png?sidcode=1668661888308"),
                        new Stock(4, "TEST4", 249000, 3.62, 39.67, 302.42, 32.0793, 6.83, 59.91, 221.13, 85.65, 66.9, 5, 0.0200477, 2.56, "https://ssl.pstatic.net/imgfinance/chart/item/area/day/005490.png?sidcode=1668661888308"),
                        new Stock(5, "TEST5", 249000, 3.62, 39.67, 302.42, 32.0793, 6.83, 59.91, 221.13, 85.65, 66.9, 5, 0.0200477, 2.56, "https://ssl.pstatic.net/imgfinance/chart/item/area/day/005490.png?sidcode=1668661888308")
                ),
                Weights.of(25,10,15,30,20)
        );
        return portFolio;
    }


    private PortFolioDto createPortfolioDto()
    {
        return new PortFolioDto(
                1L,
                List.of(
                        new Stock(1, "TEST1", 249000, 3.62, 39.67, 302.42, 32.0793, 6.83, 59.91, 221.13, 85.65, 66.9, 5, 0.0200477, 2.56, "https://ssl.pstatic.net/imgfinance/chart/item/area/day/005490.png?sidcode=1668661888308"),
                        new Stock(2, "TEST2", 249000, 3.62, 39.67, 302.42, 32.0793, 6.83, 59.91, 221.13, 85.65, 66.9, 5, 0.0200477, 2.56, "https://ssl.pstatic.net/imgfinance/chart/item/area/day/005490.png?sidcode=1668661888308"),
                        new Stock(3, "TEST3", 249000, 3.62, 39.67, 302.42, 32.0793, 6.83, 59.91, 221.13, 85.65, 66.9, 5, 0.0200477, 2.56, "https://ssl.pstatic.net/imgfinance/chart/item/area/day/005490.png?sidcode=1668661888308"),
                        new Stock(4, "TEST4", 249000, 3.62, 39.67, 302.42, 32.0793, 6.83, 59.91, 221.13, 85.65, 66.9, 5, 0.0200477, 2.56, "https://ssl.pstatic.net/imgfinance/chart/item/area/day/005490.png?sidcode=1668661888308"),
                        new Stock(5, "TEST5", 249000, 3.62, 39.67, 302.42, 32.0793, 6.83, 59.91, 221.13, 85.65, 66.9, 5, 0.0200477, 2.56, "https://ssl.pstatic.net/imgfinance/chart/item/area/day/005490.png?sidcode=1668661888308")
                ),
                new WeightsDto(1L,25,10,15,30,20)
        );
    }

}