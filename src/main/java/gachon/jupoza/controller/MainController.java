package gachon.jupoza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String index()
    {
        return "index.html";
    }
    @GetMapping("/header")
    public String header()
    {
        return "header.html";
    }
    @GetMapping("/button")
    public String button()
    {
        return "buttons.html";
    }
    @GetMapping("/portfolio")
    public String portfolio()
    {
        return "portfolio.html";
    }
    @GetMapping("/blank")
    public String blank()
    {
        return "blank.html";
    }
    @GetMapping("/blank2")
    public String blank2()
    {
        return "blank2.html";
    }
    @GetMapping("/blank3")
    public String blank3()
    {
        return "blank3.html";
    }
    @GetMapping("/category")
    public String category()
    {
        return "category.html";
    }




}
