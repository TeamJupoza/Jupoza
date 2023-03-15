package gachon.jupoza.service;

import gachon.jupoza.domain.MyStock;
import gachon.jupoza.domain.PortFolio;
import gachon.jupoza.domain.Stock;
import gachon.jupoza.domain.UserAccount;
import gachon.jupoza.dto.PortFolioDto;
import gachon.jupoza.dto.StockDto;
import gachon.jupoza.repository.MyStockRepository;
import gachon.jupoza.repository.PortfolioRepository;
import gachon.jupoza.repository.StockRepository;
import gachon.jupoza.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class MyPortfolioService {

    private final PortfolioRepository portfolioRepository;

    private final StockRepository stockRepository;

    private final UserAccountRepository userAccountRepository;

    private final MyStockRepository myStockRepository;


    // Portfolio Dto를 UserAccount 정보와 같이 엔티티화 해서 DB에 저장한다.
    public void savePortfolio(PortFolioDto portFolioDto) {
        UserAccount userAccount = userAccountRepository.getReferenceById(portFolioDto.getUserAccountDto().getUserId());


        // 포트폴리오 정보 저장


        // 1. 해당 아이디의 포트폴리오 정보가 없으면 그냥 저장
        if (portfolioRepository.findByUserAccount_UserId(userAccount.getUserId()) == null) {
            PortFolio portFolio = portFolioDto.toEntity(userAccount);
            // MyPortfolio 엔티티에 포트폴리오 정보를 매핑하기 위해 넣어줌
            for (int i = 0; i < 5; i++) {
                portFolio.getMyStockList().get(i).setPortFolio(portFolio);
                portFolio.getMyStockList().get(i).setUserId(portFolioDto.getUserAccountDto().getUserId());
            }

            portfolioRepository.save(portFolio);
            log.info(" savePortfolio 1. 해당 아이디의 포트폴리오 정보가 없으면 그냥 저장");
        }
        else // 2. 해당 아이디의 포트폴리오 정보가 있으면 업데이트

        {
            updatePortfolio(userAccount.getUserId(), portFolioDto);

            log.info(" savePortfolio 2. 해당 아이디의 포트폴리오 정보가 있으면 업데이트");
        }


    }


    /*
       포트폴리오 업데이트
       sql처럼 portfolio레코드를 삭제하면 cascade되어 자동으로 연관된 myStock레코드 까지 삭제될줄 알았는데
       수동으로 연결을 끊어줘야 삭제가 가능함
       내가 잘못한거 같은데 왜 안되는지 모르겠음

     */
    @Transactional
    public void updatePortfolio(String userId, PortFolioDto portFolioDto) {
        try {
            // portfolio 정보, user 정보를 db에서 가져온다.
            PortFolio portFolio = portfolioRepository.findByUserAccount_UserId(userId);
            UserAccount userAccount = userAccountRepository.getReferenceById(portFolioDto.getUserAccountDto().getUserId());

            // 유저 정보가 입력되지않음
            if (portFolio.getUserAccount().getUserId().equals(userAccount.getUserId())) {
                if (portFolioDto.getStockList() != null) {

                    for (int i = 0; i < 5; i++) {
                        portFolioDto.getStockList().get(i).setPortFolio(portFolio);
                    }

                    // myStock테이블과 PortFolio 테이블에 서로 연관을 null 처리함
                    for (MyStock mystock : portFolio.getMyStockList()) {
                        mystock.setPortFolio(null);
                    }
                    portFolio.setMyStockList(null);


                    // portFolio, MyStock테이블의 수정할 정보를 먼저 삭제함
                    portfolioRepository.deleteById(portFolio.getId());
                    myStockRepository.deleteByUserId(portFolio.getUserAccount().getUserId());
                    portfolioRepository.flush();

                    // Dto 로 부터 수정할 정보를 PortFolio 엔티티로 변환
                    PortFolio updatedPortFolio = portFolioDto.toEntity(userAccount);

                    // 수정할 엔티티에 연관관계 설정
                    for (int i = 0; i < 5; i++) {
                        updatedPortFolio.getMyStockList().get(i).setPortFolio(updatedPortFolio);
                        updatedPortFolio.getMyStockList().get(i).setUserId(portFolioDto.getUserAccountDto().getUserId());
                    }

                    // 수정할 엔티티를 테이블에 저장한다.
                    portfolioRepository.save(updatedPortFolio);
                }
            }

        } catch (EntityNotFoundException e) {
            log.warn("포트폴리오 업데이트 실패. 포트폴리오를 업데이트 하는데 필요한 정보를 찾을수 없습니다. - {}", e.getLocalizedMessage());
        }

    }

    // 포트폴리오 출력
    @Transactional(readOnly = true)
    public PortFolio getPortfolio(String userId) {
        try {
            return portfolioRepository.findByUserAccount_UserId(userId);
        } catch (Exception e) {
            e.getLocalizedMessage();
            return null;
        }

    }

    // 유저아이디를 받아와 포트폴리오를 삭제한다.
    // 포트폴리오엔티티와 MyStock엔티티를 둘다 삭제해야한다.
    public void DeletePortFolio(String userId) {
        PortFolio portFolio = portfolioRepository.findByUserAccount_UserId(userId);
        UserAccount userAccount = userAccountRepository.getReferenceById(userId);

        // 유저 정보가 입력되지않음
        if (portFolio.getUserAccount().getUserId().equals(userAccount.getUserId())) {
            if (portFolio.getMyStockList() != null) {

                // myStock테이블과 PortFolio 테이블에 서로 연관을 null 처리함
                for (MyStock mystock : portFolio.getMyStockList()) {
                    mystock.setPortFolio(null);
                }
                portFolio.setMyStockList(null);


                // portFolio, MyStock테이블의 수정할 정보를 먼저 삭제함
                portfolioRepository.deleteById(portFolio.getId());
                myStockRepository.deleteByUserId(portFolio.getUserAccount().getUserId());
                portfolioRepository.flush();


            }
        }
    }

    @Transactional(readOnly = true)
    public Stock getStock(int stockId) {
        return stockRepository.findById(stockId).orElseThrow(() -> new EntityNotFoundException("StockId에 해당하는 Stock이 없습니다. stockId : " + stockId));

    }


    public void deletePortfolio(Long id) {
        portfolioRepository.deleteById(id);
    }


    // Id를 매개변수로 받아 내 포트폴리오뷰를 출력하기 위해 내 포트폴리오 정보를 DB에서 가져오는 메서드
    @Transactional(readOnly = true)
    public Map<String, Object> MyPortFolio(String userId) {
        Map<String, Object> result = new HashMap<>();

        // portFoilo 정보를 DB에서 가져옴
        PortFolio portFolio = portfolioRepository.findByUserAccount_UserId(userId);

        log.info("portFolio : {} ",portFolio);

        if (portFolio != null) {


            List<Stock> StockEntityList = new ArrayList<>();
            List<Float> weights = new ArrayList<>();
            for (MyStock myStock : portFolio.getMyStockList()) {
                StockEntityList.add(stockRepository.findByStockId(myStock.getStockId()));
                weights.add(myStock.getWeight());
            }

            List<StockDto> stockList = new ArrayList<>();
            for (Stock stock : StockEntityList) {
                StockDto stockDTO = StockDto.builder()
                        .entity(stock)
                        .build();
                stockList.add(stockDTO);
            }

            result.put("stockList", stockList);
            result.put("weights", weights);
            result.put("result","success");

        }
        else{

            result.put("result", "fail");
        }
        log.info("result : {}",result);

        return result;
    }
}
