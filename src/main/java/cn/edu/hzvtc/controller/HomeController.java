package cn.edu.hzvtc.controller;

import cn.edu.hzvtc.pojo.Plate;
import cn.edu.hzvtc.pojo.ReturnMsg;
import cn.edu.hzvtc.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
        System.out.println(plates);
        return ReturnMsg.success().add("plates", plates);
    }

}
