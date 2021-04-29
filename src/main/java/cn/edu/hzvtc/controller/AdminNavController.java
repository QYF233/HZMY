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
 *
 * @author kiko
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
//    @RequestMapping(value = "/getNavs")
//    @ResponseBody
//    @CrossOrigin
//    public ReturnMsg getNavs(@RequestParam("parentId") Integer parentId) {
//        List<Plate> navs = plateService.getNavs(parentId);
//        if (navs != null) {
//            return ReturnMsg.success().add("navs", navs).add("navCount", navs.size());
//        } else {
//            return ReturnMsg.fail();
//        }
//    }
    @RequestMapping(value = "/getNavs")
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getNavs() {
//        List<Plate> navs = plateService.getNavsByParent(parentId);
        List<Plate> navs = plateService.getNavs();
        if (navs != null) {
            return ReturnMsg.success().add("navs", navs).add("navCount", navs.size());
        } else {
            return ReturnMsg.fail();
        }
    }

    @RequestMapping(value = "/getLayerNav")
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getLayerNav(@RequestParam("id") Integer id) {
        List<Plate> list = plateService.selectChildByParentId(id);
        if (list != null) {
            return ReturnMsg.success().add("list", list).add("navCount", list.size());
        } else {
            return ReturnMsg.fail();
        }
    }

    /**
     * 修改
     *
     * @param plate 修改对象
     * @return
     */
    @RequestMapping(value = "/updateNav", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg updateNav(@RequestBody Plate plate) {
        /*如果sort有变动，进行排序*/
        Plate oldPlate = plateService.getNav(plate.getId());
        Integer oldSort = oldPlate.getPlaSort();
        if (!oldSort.equals(plate.getPlaSort())) {
            plateService.updateSort(plate.getPlaSort(), oldSort, "nav", plate.getPlaParentId());
        }
        /*如果更改了父节点，sort不会变，但要变成新父节点的子节点总数*/
        if (!oldPlate.getPlaParentId().equals(plate.getPlaParentId())) {
            if (plate.getPlaParentId() != 0) {
                plate.setPlaType(5);
            }
            int navCount = plateService.selectChildByParentId(plate.getPlaParentId()).size();
            if (plate.getPlaSort() >= navCount) {
                plate.setPlaSort(navCount + 1);
            }
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
        Integer parentId = nav.getPlaParentId();
        if (plateService.delNav(id) > 0) {
            if (parentId == 0) {
                plateService.delSort(id, "navRoot");
            } else {
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
    public ReturnMsg addNav(@RequestBody Plate plate) {
        /*判断是根导航还是子导航*/
//        if (plate.getPlaParentId() != null) {
//            //子导航
//            plate.setPlaType(5);
//        } else {
//            //根导航
//            plate.setPlaType(1);
//        }
//        plate.setPlaType(1);
        /*获取当前板块总数*/
        int navCount = plateService.selectChildByParentId(plate.getPlaParentId()).size();
        /*sort+1*/
        plate.setPlaSort(navCount + 1);
        System.out.println(navCount);
        if (plateService.addNav(plate) > 0) {
            return ReturnMsg.success();
        }
        return ReturnMsg.fail();
    }
}
