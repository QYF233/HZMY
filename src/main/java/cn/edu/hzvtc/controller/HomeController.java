package cn.edu.hzvtc.controller;

import cn.edu.hzvtc.pojo.Article;
import cn.edu.hzvtc.pojo.Plate;
import cn.edu.hzvtc.pojo.ReturnMsg;
import cn.edu.hzvtc.pojo.Swiper;
import cn.edu.hzvtc.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * @author kiko
 */
@Controller
public class HomeController {

    @Autowired
    public HomeService homeService;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/list")
    public String sectionList() {
        return "sectionList";
    }

    @RequestMapping("/detail")
    public String detail() {
        return "detail";
    }

    @RequestMapping("/getPlates")
    @ResponseBody
    public ReturnMsg getSection() {
        List<Plate> plates = homeService.getList();
        return ReturnMsg.success().add("plates", plates);
    }

    @RequestMapping("/getSwiper")
    @ResponseBody
    public ReturnMsg getSwiper() {
        List<Swiper> swiper = homeService.getSwiper();
        return ReturnMsg.success().add("swiper", swiper);
    }

    @RequestMapping("/getArticle")
    @ResponseBody
    public ReturnMsg getArticle(@RequestParam("id") Integer id) {
        List<Article> articles = homeService.getArticle(id);
        return ReturnMsg.success().add("articles", articles);
    }
}
