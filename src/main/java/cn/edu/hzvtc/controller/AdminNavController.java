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
 * 导航管理
 */
@Controller
@RequestMapping("/admin/navigation")
public class AdminNavController {
    @Autowired
    public PlateService plateService;

    /**
     * 构建node
     *
     * @param nodes
     * @return
     */
    public List<Plate> setNodes(List<Plate> nodes) {
        for (Plate node : nodes) {
            int id = node.getId();
            String btn = "<div style='float:right'>" +
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
     * @param plate   修改对象
     * @param oldSort 原先sort
     * @return
     */
    @RequestMapping(value = "/updateNav", method = RequestMethod.PUT)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg updateNav(@Valid Plate plate, @RequestParam("oldSort") Integer oldSort) {
        /*如果sort有变动，进行排序*/
        if (!oldSort.equals(plate.getPlaSort())) {
            plateService.updateSort(plate.getPlaSort(), oldSort, "nav", plate.getPlaParentId());
        }
        if (plateService.updateNav(plate) > 0) {
            return ReturnMsg.success();
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
    @RequestMapping(value = "/delNav", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg delNav(@RequestParam("id") Integer id) {
        Plate nav = plateService.getNav(id);
        String parentId = String.valueOf(nav.getPlaParentId());
        System.out.println(parentId);

        if (plateService.delNav(id) > 0) {
            if (parentId.equals("null")){
                plateService.delSort(id, "navRoot");
            }else {
                plateService.delSort(id, "nav");
            }

            return ReturnMsg.success();
        }
        return ReturnMsg.fail();
    }

    /**
     * 添加
     *
     * @param plate
     * @return
     */
    @RequestMapping(value = "/addNav", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg addNav(@Valid Plate plate) {
        /*判断是根导航还是子导航*/
        if (plate.getPlaParentId() != null) {
            //子导航
            plate.setPlaType(5);
        } else {
            //根导航
            plate.setPlaType(1);
        }
        /*获取当前板块总数*/
        int navCount = plateService.getNavCount(plate.getPlaParentId());
        /*sort+1*/
        plate.setPlaSort(navCount + 1);
        if (plateService.addNav(plate) > 0) {
            return ReturnMsg.success();
        }
        return ReturnMsg.fail();
    }
}
