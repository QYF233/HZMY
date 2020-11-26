package cn.edu.hzvtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/article")
public class AdminArticleController {

    @RequestMapping("")
    public String adminArticle() {
        return "admin/Article";
    }
    @RequestMapping("/login")
    public String adminLogin() {
        return "admin/login";
    }
}
