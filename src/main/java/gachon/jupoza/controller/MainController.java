package gachon.jupoza.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@Controller
public class MainController {
    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/header")
    public String header() {
        return "header.html";
    }

    @GetMapping("/button")
    public String button() {
        return "buttons.html";
    }

    @GetMapping("/portfolio")
    public String portfolio() {
        return "portfolio.html";
    }

    @GetMapping("/blank")
    public String blank() {
        return "blank.html";
    }

    @GetMapping("/blank2")
    public String blank2() {
        return "blank2.html";
    }

    @GetMapping("/blank3")
    public String blank3() {
        return "blank3.html";
    }

    @GetMapping("/category")
    public String category() {
        return "category.html";
    }

    @GetMapping("/myportfolio")
    public String myPortFolio() {
        return "my-portfolio.html";
    }

    @GetMapping("/articleform")
    public String articleForm() {
        return "article-form.html";
    }

    @GetMapping("/articledetail/{articleId}")
    public String articleDetail(@PathVariable String articleId, ModelMap map)
    {

        map.addAttribute("articleId", articleId);
        return "article-detail.html";
    }

    @GetMapping("/article")
    public String articles() {
        return "article.html";

    }


}
