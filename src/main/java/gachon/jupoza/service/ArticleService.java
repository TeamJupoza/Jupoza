package gachon.jupoza.service;

import gachon.jupoza.domain.*;
import gachon.jupoza.dto.ArticleDto;
import gachon.jupoza.dto.Request.ArticleRequest;
import gachon.jupoza.dto.Response.ArticleResponse;
import gachon.jupoza.dto.StockDto;
import gachon.jupoza.repository.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.*;

@Transactional
@AllArgsConstructor
@Slf4j
@Service
public class ArticleService {
    private final MyPortfolioService myPortfolioService;

    private final ArticleRepository articleRepository;

    private final ArticleStockRepository articleStockRepository;

    private final UserAccountRepository userAccountRepository;

    private final MyStockRepository myStockRepository;

    private final StockRepository stockRepository;

    public void saveArticle(ArticleRequest articleRequest) {
        // 유저 정보 DB에서 조회
        UserAccount userAccount = userAccountRepository.findByUserId(articleRequest.getUserId()).get();
        ArticleDto articleDto = articleRequest.toDto();
        Article article = articleDto.toEntity(userAccount);

        // portfolio DB에서 stock 정보를 가져와 articleStockList 에 담는다.
        List<ArticleStock> articleStockList = new ArrayList<>();

        List<MyStock> myStockList = myStockRepository.findAllByUserId(userAccount.getUserId());

        for (MyStock myStock : myStockList) {
            articleStockList.add(ArticleStock.of(article, myStock.getStockId(), myStock.getWeight(), myStock.getUserId()));
        }
        article.setMyStockList(articleStockList);


        log.info("article : {} ", article);

        articleRepository.save(article);


    }

    public void deleteArticle(Long articleId, String userId) {
        UserAccount userAccount = userAccountRepository.findByUserId(userId).get();
        log.info("Delete_userAccount : {} ", userAccount);
        Article article = articleRepository.getReferenceById(articleId);

        if (userAccount.getUserId() == article.getUserAccount().getUserId()) {
            articleRepository.deleteById(articleId);
        }

    }

    public void updateArticle(Long articleId, ArticleRequest articleRequest) {
        // article 정보, user 정보를 db에서 가져온다.
        Optional<Article> article = articleRepository.findById(articleId);
        article.orElseThrow();
        UserAccount userAccount = userAccountRepository.findByUserId(articleRequest.getUserId()).get();

        // articleRequest로 부터 article 객체를 파싱함
        Article updatingArticle = articleRequest.toDto().toEntity(userAccount);

        if (article.get().getUserAccount().getUserId() == userAccount.getUserId()) {
            for (ArticleStock articleStock : updatingArticle.getMyStockList()) {
                articleStock.setArticle(updatingArticle);
            }

            // 수정될 article 을 먼저 삭제

            // article 과 articleStockList 의 연관관계를 끊고 삭제함
//            for (ArticleStock articleStock : article.get().getMyStockList())
//            {
//                articleStock.setArticle(null);
//            }
//            article.get().setMyStockList(null);

            articleStockRepository.deleteByArticleId(article.get().getId());
            articleRepository.deleteById(article.get().getId());

            // 수정된 article을 DB에 저장한다.
            articleRepository.save(updatingArticle);

        }


    }

    // 페이징 해야함
    public void findAllArticle() {

    }

    @Transactional(readOnly = true)
    public Map<String, Object> findOneArticle(Long articleId) {
        try {

            // getReferenceById 로 받으면 LAZY 에러가 날수있다. 이유는 JPA 공부 필요
            Optional<Article> article = articleRepository.findById(articleId);

            Map<String, Object> request = new HashMap<>();

            request.put("article", article.get());

            // Stock-> StockDto로 변환해서 반환하기
            // 내 포트폴리오 정보를 이용해 stock들의 정보를 가져옴
            List<Stock> StockEntityList = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                StockEntityList.add(this.getStock(article.get().getMyStockList().get(i).getStockId()));
            }
            // stock entity -> stockDto로 변환하기

            List<StockDto> stockList = new ArrayList<>();
            for (Stock stock : StockEntityList) {
                StockDto stockDTO = StockDto.builder()
                        .entity(stock)
                        .build();
                stockList.add(stockDTO);
            }
            request.put("stockList", stockList);

            // weight 반환하기
            List<Float> weights = new ArrayList<>();
            for (ArticleStock articleStock : article.get().getMyStockList()
            ) {
                weights.add(articleStock.getWeight());
            }
            request.put("weights", weights);


            return request;
        } catch (Exception e) {
            e.getLocalizedMessage();
            return null;
        }


    }


    public List<ArticleResponse> getAllArticles() {
        List<Article> articleList = articleRepository.findAll();
        List<ArticleResponse> articleResponseList = new ArrayList<>();
        for (Article article : articleList) {
            articleResponseList.add(ArticleResponse.of(
                    String.valueOf(article.getId()),
                    article.getTitle(),
                    article.getCreatedBy(),
                    String.valueOf(article.getCreatedAt())
            ));

        }
        return articleResponseList;
    }

    @Transactional(readOnly = true)
    public Stock getStock(int stockId) {
        return stockRepository.findById(stockId).orElseThrow(() -> new EntityNotFoundException("StockId에 해당하는 Stock이 없습니다. stockId : " + stockId));

    }

}
