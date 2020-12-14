package cn.edu.hzvtc.controller;

import cn.edu.hzvtc.pojo.Article;
import cn.edu.hzvtc.pojo.Plate;
import cn.edu.hzvtc.service.AdminSecService;
import cn.edu.hzvtc.service.PlateService;
import cn.edu.hzvtc.tools.ReturnMsg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 板块管理
 */
@Controller
@RequestMapping("/admin/section")
public class AdminSecController {
    @Autowired
    public PlateService plateService;

    @Autowired
    public AdminSecService adminSecService;

    /**
     * 获取板块列表
     *
     * @return List
     */
    @RequestMapping("/getSection")
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getSection() {
        List<Plate> sec = plateService.getSection();
        if (sec != null) {
            return ReturnMsg.success().add("sec", sec).add("secCount", sec.size());
        } else {
            return ReturnMsg.fail();
        }
    }

    /**
     * 获取单个数据
     *
     * @param id 板块id
     * @return Plate
     */
    @RequestMapping(value = "/getSec", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getSec(@RequestParam("id") Integer id) {
        Plate sec = plateService.getSec(id);
        if (sec != null) {
            return ReturnMsg.success().add("sec", sec);
        } else {
            return ReturnMsg.fail();
        }
    }

    /**
     * 删除
     *
     * @param id 删除id
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
     * 批量删除
     *
     * @param ids 删除id列表
     * @return
     */
    @RequestMapping(value = "/delSec/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public ReturnMsg delSec(@PathVariable("ids") String ids) {
        if (plateService.delSec(ids)) {
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
        int secCount = adminSecService.getSecCount();
        plate.setPlaSort(secCount + 1);
        if (plateService.addNav(plate) > 0) {
            return ReturnMsg.success();
        }
        return ReturnMsg.fail();
    }

    /**
     * 更新数据
     *
     * @param plate
     * @param oldSort 原先顺序
     * @return
     */
    @RequestMapping(value = "/updateSec", method = RequestMethod.PUT)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg updateSec(@Valid Plate plate, @RequestParam("oldSort") Integer oldSort) {
        /*如果sort有变动，进行排序*/
        if (!oldSort.equals(plate.getPlaSort())) {
            plateService.updateSort(plate.getPlaSort(), oldSort, "sec", null);
        }
        if (plateService.updateSec(plate) > 0) {
            return ReturnMsg.success();
        } else {
            return ReturnMsg.fail();
        }
    }

}
