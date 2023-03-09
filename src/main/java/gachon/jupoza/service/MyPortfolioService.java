package gachon.jupoza.service;

import gachon.jupoza.domain.PortFolio;
import gachon.jupoza.domain.UserAccount;
import gachon.jupoza.dto.PortFolioDto;
import gachon.jupoza.repository.PortfolioRepository;
import gachon.jupoza.repository.UserAccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class MyPortfolioService {

     private final PortfolioRepository portfolioRepository;

     private final UserAccountRepository userAccountRepository;

    // Portfolio Dto를 UserAccount 정보와 같이 엔티티화 해서 DB에 저장한다.
    public void savePortfolio(PortFolioDto dto) {
        UserAccount userAccount = userAccountRepository.findByUserId(dto.getUserAccountDto().getUserId());
        portfolioRepository.save(dto.toEntity(userAccount));

    }

    public void updatePortfolio(Long id, PortFolioDto dto) {
        try {
            PortFolio portFolio = portfolioRepository.getReferenceById(id);

            
            UserAccount userAccount = userAccountRepository.findByUserId(dto.getUserAccountDto().getUserId());
            System.out.println(userAccount);
            // 유저 정보가 입력되지안흥ㅁ
//            if (portFolio.getUserAccount().getUser_id().equals(userAccount.getUser_id()))
//            {
//                if (dto.getStockList() != null){portFolio.setStockList(dto.getStockList());}
//                if (dto.getWeights() != null){portFolio.setWeights(dto.getWeights());}
//            }
            portFolio.setStockList(dto.getStockList());
            portFolio.setWeights(dto.getWeights());
        }catch (EntityNotFoundException e)
        {
            log.warn("포트폴리오 업데이트 실패. 포트폴리오를 업데이트 하는데 필요한 정보를 찾을수 없습니다. - {}", e.getLocalizedMessage());
        }

    }

    @Transactional(readOnly = true)
    public PortFolioDto getPortfolio(Long portfolioId) {
        return portfolioRepository.findById(portfolioId)
                .map(PortFolioDto::from)
                .orElseThrow(() -> new EntityNotFoundException("포트폴리오가 없습니다. - articleId :" + portfolioId));
    }

    public void deletePortfolio(Long id) {
        portfolioRepository.deleteById(id);
    }
}
