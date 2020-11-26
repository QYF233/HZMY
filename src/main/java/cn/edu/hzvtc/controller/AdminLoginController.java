package cn.edu.hzvtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author kiko
 */

@Controller
@RequestMapping("/login")
public class AdminLoginController {
    @RequestMapping("")
    public String adminArticle() {
        return "admin/login";
    }


}
