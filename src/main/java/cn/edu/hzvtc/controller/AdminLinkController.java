package cn.edu.hzvtc.controller;

import cn.edu.hzvtc.pojo.Link;
import cn.edu.hzvtc.service.HomeService;
import cn.edu.hzvtc.service.LinkService;
import cn.edu.hzvtc.tools.ReturnMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/links")
public class AdminLinkController {
    @Autowired
    public LinkService linkService;

    /**
     * 获取页底
     *
     * @return ReturnMsg
     */
    @RequestMapping("/getLinks")
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getLinks() {
        List<Link> links = linkService.getLinks();
        return ReturnMsg.success().add("links", links);
    }

    /**
     * 按id查询
     * @param id
     * @return
     */
    @RequestMapping("/getLink")
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getLink(@RequestParam("id") Integer id) {
        Link link = linkService.getLink(id);
        return ReturnMsg.success().add("link", link);
    }

    /**
     * 更新排序
     * @param id
     * @param newSort
     * @return
     */
    @RequestMapping("/updateSort")
    @ResponseBody
    @CrossOrigin
    public ReturnMsg updateSort(@RequestParam("id") Integer id, @RequestParam("newSort") Integer newSort) {
        if (linkService.updateSort(id, newSort) == 1) {
            return ReturnMsg.success();
        } else {
            return ReturnMsg.fail();
        }
    }

    /**
     * 更新链接
     * @param link
     * @return
     */
    @RequestMapping(value = "/updateLink", method = RequestMethod.PUT)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg updateLink(Link link) {
        if (linkService.updateLink(link) == 1) {
            return ReturnMsg.success();
        } else {
            return ReturnMsg.fail();
        }
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/delLink", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg delLink(@RequestParam("id") Integer id) {
        if (linkService.delLink(id) > 0) {
            return ReturnMsg.success();
        } else {
            return ReturnMsg.fail();
        }
    }

    /**
     * 添加
     * @param link
     * @return
     */
    @RequestMapping(value = "/addLink", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg addLink(Link link) {
        if (linkService.addLink(link) == 1) {
            return ReturnMsg.success();
        } else {
            return ReturnMsg.fail();
        }
    }
}
