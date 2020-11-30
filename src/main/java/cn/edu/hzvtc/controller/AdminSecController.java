package cn.edu.hzvtc.controller;

import cn.edu.hzvtc.pojo.Article;
import cn.edu.hzvtc.pojo.Plate;
import cn.edu.hzvtc.service.PlateService;
import cn.edu.hzvtc.tools.ReturnMsg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/section")
public class AdminSecController {
    @Autowired
    public PlateService plateService;

    @RequestMapping("/getSection")
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getSection() {
        List<Plate> sec = plateService.getSection();
        System.out.println(sec.size());
        return ReturnMsg.success().add("sec", sec).add("secCount", sec.size());
    }

    @RequestMapping(value = "/getSec", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getSec(@RequestParam("id") Integer id) {
        Plate sec = plateService.getSec(id);
        return ReturnMsg.success().add("sec", sec);
    }

    /**
     * 删除
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/delSec", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg delSec(@RequestParam("id") Integer id) {
        if (plateService.delNav(id) > 0) {
            return ReturnMsg.success();
        }
        return ReturnMsg.fail();
    }

    /**
     * 添加
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/addSec", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg addSec(@Valid Plate plate) {
        if (plate.getPlaParentId() != null) {
            plate.setPlaType(2);
        } else {
            plate.setPlaType(4);
        }
        int navCount = plateService.getNavCount(plate.getPlaParentId());
        plate.setPlaSort(navCount + 1);
        if (plateService.addNav(plate) > 0) {
            return ReturnMsg.success();
        }
        return ReturnMsg.fail();
    }
}
