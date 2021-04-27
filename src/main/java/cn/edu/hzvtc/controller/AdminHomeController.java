package cn.edu.hzvtc.controller;

import cn.edu.hzvtc.pojo.Plate;
import cn.edu.hzvtc.service.AdminSecService;
import cn.edu.hzvtc.service.AdminUserService;
import cn.edu.hzvtc.service.ArticleService;
import cn.edu.hzvtc.service.PlateService;
import cn.edu.hzvtc.tools.ReturnMsg;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台首页
 *
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
        //板块名字、文章数
        HashMap<String, Object> barData = new HashMap<String, Object>();
        //板块名字、浏览量
        HashMap<String, Object> pieData = new HashMap<String, Object>();

        List<Plate> plates = plateService.getPlates(true);
        List<String> secName = new ArrayList<>();
        List<Integer> artCount = new ArrayList<>();
        List<Long> sightCount = new ArrayList<>();
        List<Object> pie = new ArrayList<>();
        for (int i = 0; i < plates.size(); i++) {
            secName.add(plates.get(i).getPlaName());
            artCount.add(plates.get(i).getArticles().size());
            sightCount.add(plates.get(i).getSightCount());
        }
        //板块名字、文章数
        barData.put("secName", secName);
        barData.put("artCount", artCount);
        //板块名字、浏览量\[{value: ,name:}]
        pieData.put("secName", secName);
        pieData.put("sightCount", sightCount);
        return ReturnMsg.success().add("barData", barData).add("pieData", pieData);
    }
}
