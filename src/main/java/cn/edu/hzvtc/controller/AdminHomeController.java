package cn.edu.hzvtc.controller;

import cn.edu.hzvtc.pojo.Plate;
import cn.edu.hzvtc.service.AdminSecService;
import cn.edu.hzvtc.service.AdminUserService;
import cn.edu.hzvtc.service.ArticleService;
import cn.edu.hzvtc.service.PlateService;
import cn.edu.hzvtc.tools.ReturnMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 后台首页
 * @author kiko
 */
@Controller
@RequestMapping("/admin/home")
public class AdminHomeController {
    @Autowired
    public AdminUserService adminUserService;

    @Autowired
    public AdminSecService adminSecService;

    @Autowired
    public ArticleService articleService;

    @Autowired
    public PlateService plateService;

    /**
     * 后台首页获取统计信息
     *
     * @return 统计信息
     */
    @RequestMapping("/getCount")
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getCount() {
        Long userCount = adminUserService.getUserCount();
        int secCount = adminSecService.getSecCount();
        Long artCount = articleService.getArtCount();
        Long artSightCount = articleService.getArtSightCount();
        return ReturnMsg.success().add("userCount", userCount).add("secCount", secCount).add("artCount", artCount).add("artSightCount", artSightCount);
    }

    /**
     * 获取板块下的所有文章
     *
     * @return
     */
    @RequestMapping("/getSectionChart")
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getSectionChart() {
        List<Plate> plates = plateService.getPlates(true);
        return ReturnMsg.success().add("plates", plates);
    }
}
