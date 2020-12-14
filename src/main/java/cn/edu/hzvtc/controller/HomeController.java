package cn.edu.hzvtc.controller;

import cn.edu.hzvtc.pojo.*;
import cn.edu.hzvtc.service.HomeService;
import cn.edu.hzvtc.tools.ReturnMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * 前台首页
 */
@Controller
public class HomeController {

    @Autowired
    public HomeService homeService;

    /**
     * 获取导航信息
     * @return ReturnMsg
     */
    @RequestMapping("/getPlates")
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getSection() {
        List<Plate> plates = homeService.getList();
        return ReturnMsg.success().add("plates", plates);
    }
    /**
     * 获取轮播图
     * @return ReturnMsg
     */
    @RequestMapping("/getSwiper")
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getSwiper() {
        List<Swiper> swiper = homeService.getSwiper();
        return ReturnMsg.success().add("swiper", swiper);
    }

    /**
     * 获取文章列表
     * @param plateId 板块id
     * @return ReturnMsg
     */
    @RequestMapping("/getArticle")
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getArticle(@RequestParam("plateId") Integer plateId) {
        List<Article> articles = homeService.getArticle(plateId,"limit");
        return ReturnMsg.success().add("articles", articles);
    }

    /**
     * 获取页底
     * @return ReturnMsg
     */
    @RequestMapping("/getLink")
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getLink() {
        List<Link> links = homeService.getLinks();
        return ReturnMsg.success().add("links", links);
    }
}
