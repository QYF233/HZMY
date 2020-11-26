package cn.edu.hzvtc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/admin")
public class AdminHomeController {
    @RequestMapping("index")
    public String adminIndex() {
        return "admin/index";
    }
}
