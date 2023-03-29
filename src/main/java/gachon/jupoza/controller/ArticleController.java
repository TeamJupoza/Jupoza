package gachon.jupoza.controller;

import com.fasterxml.jackson.core.JsonProcessingException;


import gachon.jupoza.dto.Request.ArticleRequest;
import gachon.jupoza.dto.Response.ArticleResponse;
import gachon.jupoza.service.ArticleService;
import gachon.jupoza.utils.securityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/article")
public class ArticleController {


    private final ArticleService articleService;


    // 게시글 등록,수정 ( 게시글이 존재하면 게시글을 삭제하고 다시 추가해 수정함 )
    @PostMapping("/api/save")
    ResponseEntity<Map<String, Object>> saveArticle(@RequestBody ArticleRequest articleRequest) {
        Map<String, Object> result = new HashMap<>();


        log.info("ArticleRequest : {}", articleRequest);
        if (articleRequest.getArticleStockList().isEmpty() || articleRequest.getTitle().isEmpty() || articleRequest.getContent().isEmpty())
        {
            result.put("result,","fail");
            return new ResponseEntity(result, HttpStatus.BAD_REQUEST);
        }
        try{
            articleService.saveArticle(articleRequest);
            result.put("result", "success");
            return new ResponseEntity(result, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getLocalizedMessage();
            result.put("result", "fali");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }

    // 게시글 삭제

    @GetMapping("/api/delete/{articleId}/{userId}")
    Map<String, Object> deleteArticle(@PathVariable String userId, @PathVariable Long articleId) {
        log.info("delete  userId : {}, articleId : {}", userId, articleId);


        articleService.deleteArticle(articleId, userId);
        Map<String, Object> result = new HashMap<>();

        result.put("result", "success");


        return result;
    }


    // 게시글 조회
    @Transactional
    @GetMapping("/api/{articleId}")
    public Map<String, Object> findOneArticle(@PathVariable Long articleId) throws JsonProcessingException {
        log.info("article articleId : {}",articleId);

        Map<String,Object> result =articleService.findOneArticle(articleId);

        log.info("article result : {}",result);

        result.put("result", "success");

        return result;

    }

    // 게시글 수정
    @Transactional
    @PostMapping("/api/update/{articleId}")
    Map<String, Object> updateArticle(@PathVariable Long articleId, @RequestBody ArticleRequest articleRequest) {

        Map<String, Object> result = new HashMap<>();


        articleService.updateArticle(articleId, articleRequest);

        result.put("result", "success");

        return result;

    }

    // 게시판 조회를 위해 모든 게시글을 반환한다.
    @GetMapping("api/get-all-articles")
    Map<String, Object> findAllArticles() {
        Map<String, Object> result = new HashMap<>();

        List<ArticleResponse> articleResponseList = articleService.getAllArticles();


        result.put("data", articleResponseList);

        return result;

    }

    @GetMapping("/api/article-form/validation/{userId}")
    ResponseEntity<Map<String, Object>> validation(@PathVariable String userId)
    {
        Map<String, Object> result = new HashMap<>();

        String currentMemberId = securityUtil.getCurrentMemberId();

        log.info("글쓰기 {} , {}", userId, currentMemberId);

        if (userId.equals(currentMemberId))
        {
            log.info("성공");
            result.put("result", "success");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else
        {
            log.info("실패");
            result.put("result", "fail");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }


}
