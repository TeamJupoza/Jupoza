package gachon.jupoza.controller;

import gachon.jupoza.service.MyPortfolioService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


@DisplayName("View 컨트롤러 - 내 포트폴리오 정보")
@WebMvcTest(MyPortfolioController.class)
class MyPortfolioControllerTest {

    private final MockMvc mvc;

    @MockBean private MyPortfolioService myPortfolioService;

    public MyPortfolioControllerTest(@Autowired MockMvc mvc, @Autowired MyPortfolioService myPortfolioService) {
        this.mvc = mvc;
        this.myPortfolioService = myPortfolioService;
    }



    // 내 DB에 포트폴리오 정보를 저장
    @DisplayName("[view][Post] 내 포트폴리오 정보 등록 - 정상 호출")
    @Test
    void givenPortfolioInfo_whenRequesting_thenSaveMyPortfolioInfo()
    {
        // given

        // when

        // then
    }
    // 내 포트폴리오 정보 출력

    // 내 포트폴리오 정보 삭제

    // 내 포트폴리오 정보 수정
}