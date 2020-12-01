package cn.edu.hzvtc.controller;


import cn.edu.hzvtc.pojo.Plate;
import cn.edu.hzvtc.service.PlateService;
import cn.edu.hzvtc.tools.ReturnMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author kiko
 */
@Controller
@RequestMapping("/admin/navigation")
public class AdminNavController {
    @Autowired
    public PlateService plateService;

    public List<Plate> setNodes(List<Plate> nodes) {
        for (Plate node : nodes) {
            int id = node.getId();
            String btn = "<div style='float:right'>" +
//                            "<input plateId="+id+" type=\"submit\" value=\"修改\" class=\"updateBtn mr-2 btn btn-primary\" data-toggle=\"modal\" data-target=\"#myModal\">\n" +
                    "<input plateId=" + id + " type=\"submit\" value=\"修改\" class=\"updateBtn mr-2 btn btn-primary\" onclick='beforeUpdate()'>\n" +
                    "<input plateId=" + id + " type=\"submit\" value=\"删除\" class=\"delBtn mr-2 btn btn-danger\" onclick='beforeDelete()'>" +
                    "</div>";
            String newTxt = node.getText() + btn;
            node.setText(newTxt);
            if (node.getNodes().isEmpty()) {
                node.setNodes(null);
            } else {
                setNodes(node.getNodes());
            }
        }
        return nodes;
    }

    /**
     * 获取所有导航信息 type = 1
     *
     * @return 导航列表
     */
    @RequestMapping(value = "/getNavs")
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getNavs() {
        List<Plate> navs = plateService.getNavs();
        navs = setNodes(navs);
        return ReturnMsg.success().add("navs", navs).add("navCount", navs.size());
    }

    /**
     * 修改
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/updateNav", method = RequestMethod.PUT)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg updateNav(@Valid Plate plate) {
        System.out.println(plate.toString());
        int oldSort = plate.getPlaSort();
        if (oldSort == 1) {
            plate.setPlaSort(-1);
        }
        if (oldSort == plateService.getNavCount(plate.getPlaParentId())) {
            plate.setPlaSort(999);
        }
        if (plateService.updateNav(plate) > 0) {
            /* 获取所有父节点相同的元素列表，遍历，若sort相同，id不相同，*/
            List<Plate> sortList = plateService.selectChildByParentId(plate.getPlaParentId());
            System.out.println(sortList);
            int index = 1;
            for (Plate value : sortList) {
                System.out.println(value.getPlaSort());
                if ((value.getPlaSort() == oldSort && value.getId() > plate.getId())) {
                    plateService.updateSort(value.getId(), index++);
                } else if (value.getId() - plate.getId() == 0) {
                    index++;
                } else {
                    plateService.updateSort(value.getId(), index++);
                }
            }

            plateService.updateSort(plate.getId(), oldSort);
            return ReturnMsg.success();
        } else {
            return ReturnMsg.fail();
        }
    }

    /**
     * 删除
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/delNav", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg delNav(@RequestParam("id") Integer id) {
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
    @RequestMapping(value = "/addNav", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg addNav(@Valid Plate plate) {
        if (plate.getPlaParentId() != null) {
            plate.setPlaType(5);
        } else {
            plate.setPlaType(1);
        }
        int navCount = plateService.getNavCount(plate.getPlaParentId());
        plate.setPlaSort(navCount + 1);
        if (plateService.addNav(plate) > 0) {
            return ReturnMsg.success();
        }
        return ReturnMsg.fail();
    }
}
