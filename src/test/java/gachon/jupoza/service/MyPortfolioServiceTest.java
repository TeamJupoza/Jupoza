package gachon.jupoza.service;


import gachon.jupoza.domain.PortFolio;
import gachon.jupoza.domain.Stock;
import gachon.jupoza.domain.UserAccount;
import gachon.jupoza.domain.Weights;
import gachon.jupoza.dto.PortFolioDto;
import gachon.jupoza.dto.UserAccountDto;
import gachon.jupoza.dto.WeightsDto;
import gachon.jupoza.repository.PortfolioRepository;
import gachon.jupoza.repository.UserAccountRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;


@DisplayName("비즈니스 로직 - 내 포트폴리오 정보")
@ExtendWith(MockitoExtension.class)
class MyPortfolioServiceTest {

    @InjectMocks private MyPortfolioService sut;

    @Mock private PortfolioRepository portfolioRepository;

    @Mock private UserAccountRepository userAccountRepository;

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
        PortFolioDto dto = createPortfolioDto(
                1L,
                UserAccountDto.from(createUser()),
                List.of(
                        new Stock(6, "TEST6", 249000, (float) 3.62,  (float) 39.67, (float)  302.42, (float)  32.0793, (float)  6.83,  (float) 59.91,  (float) 221.13, (float)  85.65,  (float) 66.9, (float)  5, (float)  0.0200477, (float)  2.56, "https://ssl.pstatic.net/imgfinance/chart/item/area/day/005490.png?sidcode=1668661888308"),
                        new Stock(7, "TEST7", 249000, (float) 3.62,  (float) 39.67, (float)  302.42, (float)  32.0793, (float)  6.83,  (float) 59.91,  (float) 221.13, (float)  85.65,  (float) 66.9, (float)  5, (float)  0.0200477, (float)  2.56, "https://ssl.pstatic.net/imgfinance/chart/item/area/day/005490.png?sidcode=1668661888308"),
                        new Stock(8, "TEST8", 249000,(float) 3.62,  (float) 39.67, (float)  302.42, (float)  32.0793, (float)  6.83,  (float) 59.91,  (float) 221.13, (float)  85.65,  (float) 66.9, (float)  5, (float)  0.0200477, (float)  2.56, "https://ssl.pstatic.net/imgfinance/chart/item/area/day/005490.png?sidcode=1668661888308"),
                        new Stock(9, "TEST9", 249000,(float) 3.62,  (float) 39.67, (float)  302.42, (float)  32.0793, (float)  6.83,  (float) 59.91,  (float) 221.13, (float)  85.65,  (float) 66.9, (float)  5, (float)  0.0200477, (float)  2.56, "https://ssl.pstatic.net/imgfinance/chart/item/area/day/005490.png?sidcode=1668661888308"),
                        new Stock(10, "TEST10", 249000,(float) 3.62,  (float) 39.67, (float)  302.42, (float)  32.0793, (float)  6.83,  (float) 59.91,  (float) 221.13, (float)  85.65,  (float) 66.9, (float)  5, (float)  0.0200477, (float)  2.56, "https://ssl.pstatic.net/imgfinance/chart/item/area/day/005490.png?sidcode=1668661888308")
                ),
                new WeightsDto(2L,25,10,15,30,20).toEntity()
        );


        given(portfolioRepository.getReferenceById(dto.getId())).willReturn(portFolio);
//        given(userAccountRepository.getReferenceById(dto.getUserAccountDto().getId())).willReturn(dto.getUserAccountDto().toEntity());



        // when
        sut.updatePortfolio(dto.getId(), dto);

        // then
        assertThat(portFolio).
                hasFieldOrPropertyWithValue("stockList", portFolio.getStockList())
                .hasFieldOrPropertyWithValue("weights",portFolio.getWeights());
        then(portfolioRepository).should().getReferenceById(dto.getId());
    }

    // 내 포트폴리오 정보를 삭제
    @DisplayName("[service] 포트폴리오ID 입력하면  포트폴리오를 삭제한다.")
    @Test
    void givenPortfolioId_whenDeletingPortfolio_thenDeletesPortfolio()
    {
        // given
        Long id = 1L;

        willDoNothing().given(portfolioRepository).deleteById(id);

        // when
        sut.deletePortfolio(id);

        // then
        then(portfolioRepository).should().deleteById(id);
    }






    private PortFolio createPortfolio() {
        PortFolio portFolio = PortFolio.of(

                createUser(),
                List.of(
                        new Stock(1, "TEST1", 249000, (float) 3.62,  (float) 39.67, (float)  302.42, (float)  32.0793, (float)  6.83,  (float) 59.91,  (float) 221.13, (float)  85.65,  (float) 66.9, (float)  5, (float)  0.0200477, (float)  2.56, "https://ssl.pstatic.net/imgfinance/chart/item/area/day/005490.png?sidcode=1668661888308"),
                        new Stock(2, "TEST2", 249000, (float) 3.62,  (float) 39.67, (float)  302.42, (float)  32.0793, (float)  6.83,  (float) 59.91,  (float) 221.13, (float)  85.65,  (float) 66.9, (float)  5, (float)  0.0200477, (float)  2.56, "https://ssl.pstatic.net/imgfinance/chart/item/area/day/005490.png?sidcode=1668661888308"),
                        new Stock(3, "TEST3", 249000, (float) 3.62,  (float) 39.67, (float)  302.42, (float)  32.0793, (float)  6.83,  (float) 59.91,  (float) 221.13, (float)  85.65,  (float) 66.9, (float)  5, (float)  0.0200477, (float)  2.56, "https://ssl.pstatic.net/imgfinance/chart/item/area/day/005490.png?sidcode=1668661888308"),
                        new Stock(4, "TEST4", 249000, (float) 3.62,  (float) 39.67, (float)  302.42, (float)  32.0793, (float)  6.83,  (float) 59.91,  (float) 221.13, (float)  85.65,  (float) 66.9, (float)  5, (float)  0.0200477, (float)  2.56, "https://ssl.pstatic.net/imgfinance/chart/item/area/day/005490.png?sidcode=1668661888308"),
                        new Stock(5, "TEST5", 249000,(float) 3.62,  (float) 39.67, (float)  302.42, (float)  32.0793, (float)  6.83,  (float) 59.91,  (float) 221.13, (float)  85.65,  (float) 66.9, (float)  5, (float)  0.0200477, (float)  2.56, "https://ssl.pstatic.net/imgfinance/chart/item/area/day/005490.png?sidcode=1668661888308")
                ),
                Weights.of(25,10,15,30,20)
        );
        return portFolio;
    }


    private PortFolioDto createPortfolioDto()
    {
        return createPortfolioDto(
                1L,
                UserAccountDto.from(createUser()),
                List.of(
                        new Stock(1, "TEST1", 249000, (float) 3.62,  (float) 39.67, (float)  302.42, (float)  32.0793, (float)  6.83,  (float) 59.91,  (float) 221.13, (float)  85.65,  (float) 66.9, (float)  5, (float)  0.0200477, (float)  2.56, "https://ssl.pstatic.net/imgfinance/chart/item/area/day/005490.png?sidcode=1668661888308"),
                        new Stock(2, "TEST2", 249000, (float) 3.62,  (float) 39.67, (float)  302.42, (float)  32.0793, (float)  6.83,  (float) 59.91,  (float) 221.13, (float)  85.65,  (float) 66.9, (float)  5, (float)  0.0200477, (float)  2.56, "https://ssl.pstatic.net/imgfinance/chart/item/area/day/005490.png?sidcode=1668661888308"),
                        new Stock(3, "TEST3", 249000, (float) 3.62,  (float) 39.67, (float)  302.42, (float)  32.0793, (float)  6.83,  (float) 59.91,  (float) 221.13, (float)  85.65,  (float) 66.9, (float)  5, (float)  0.0200477, (float)  2.56, "https://ssl.pstatic.net/imgfinance/chart/item/area/day/005490.png?sidcode=1668661888308"),
                        new Stock(4, "TEST4", 249000, (float) 3.62,  (float) 39.67, (float)  302.42, (float)  32.0793, (float)  6.83,  (float) 59.91,  (float) 221.13, (float)  85.65,  (float) 66.9, (float)  5, (float)  0.0200477, (float)  2.56, "https://ssl.pstatic.net/imgfinance/chart/item/area/day/005490.png?sidcode=1668661888308"),
                        new Stock(5, "TEST5", 249000, (float) 3.62,  (float) 39.67, (float)  302.42, (float)  32.0793, (float)  6.83,  (float) 59.91,  (float) 221.13, (float)  85.65,  (float) 66.9, (float)  5, (float)  0.0200477, (float)  2.56, "https://ssl.pstatic.net/imgfinance/chart/item/area/day/005490.png?sidcode=1668661888308")
                ),
                new WeightsDto(1L,25,10,15,30,20).toEntity()
        );
    }

    private PortFolioDto createPortfolioDto(Long id, UserAccountDto userAccount, List<Stock> stockList, Weights weights)
    {
        return PortFolioDto.of(id,userAccount,stockList,weights);
    }

    private UserAccount createUser()
    {
        return UserAccount.of("minsang","minsang","minsang@minsang.com","minsangNick","memo");
    }

}