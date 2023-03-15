package gachon.jupoza.service;


import gachon.jupoza.domain.MyStock;
import gachon.jupoza.domain.PortFolio;
import gachon.jupoza.domain.UserAccount;
import gachon.jupoza.dto.PortFolioDto;
import gachon.jupoza.dto.UserAccountDto;
import gachon.jupoza.repository.PortfolioRepository;
import gachon.jupoza.repository.UserAccountRepository;
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
        System.out.println(portFolio);
        // when
        PortFolio dto = sut.getPortfolio(portFolio.getUserAccount().getUserId());
        System.out.println(dto);
        // then
        assertThat(dto).
                hasFieldOrPropertyWithValue("myStockList", portFolio.getMyStockList());
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
                UserAccountDto.from(createUser()),
                List.of(
                        new MyStock(6,10),
                        new MyStock(7,30),
                        new MyStock(8,20),
                        new MyStock(9,15),
                        new MyStock(10,15)
                )
        );


        given(portfolioRepository.findByUserAccount_UserId(dto.getUserAccountDto().getUserId())).willReturn(portFolio);
//        given(userAccountRepository.getReferenceById(dto.getUserAccountDto().getId())).willReturn(dto.getUserAccountDto().toEntity());



        // when
        sut.updatePortfolio(dto.getUserAccountDto().getUserId(), dto);

        // then
        assertThat(portFolio).
                hasFieldOrPropertyWithValue("myStockList", portFolio.getMyStockList());
        then(portfolioRepository).should().findByUserAccount_UserId(dto.getUserAccountDto().getUserId());
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
                        new MyStock(1,20),
                        new MyStock(2,20),
                        new MyStock(3,20),
                        new MyStock(4,20),
                        new MyStock(5,20)
                )

        );
        for (int i = 0; i < 5; i++) {
            portFolio.getMyStockList().get(i).setPortFolio(portFolio);
        }

        return portFolio;
    }


    private PortFolioDto createPortfolioDto()
    {
        PortFolioDto portFolioDto = PortFolioDto.of(
                UserAccountDto.from(createUser()),
                List.of(
                        new MyStock(1,20),
                        new MyStock(2,20),
                        new MyStock(3,20),
                        new MyStock(4,20),
                        new MyStock(5,20)
                )

        );
        for (int i = 0; i < 5; i++) {
            portFolioDto.getStockList().get(i).setPortFolio(portFolioDto.toEntity(portFolioDto.getUserAccountDto().toEntity()));
        }
        return portFolioDto;
    }

    private PortFolioDto createPortfolioDto(UserAccountDto userAccount, List<MyStock> stockList)
    {
        return PortFolioDto.of(userAccount,stockList);
    }

    private UserAccount createUser()
    {
        return UserAccount.of("minsang","minsang","minsang@minsang.com","minsangNick","memo");
    }

}