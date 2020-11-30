package cn.edu.hzvtc.controller;

import cn.edu.hzvtc.pojo.Article;
import cn.edu.hzvtc.tools.ReturnMsg;
import cn.edu.hzvtc.service.ArticleService;
import cn.edu.hzvtc.service.HomeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/section")
public class SectionController {
    @Autowired
    public ArticleService articleService;
    @Autowired
    public HomeService homeService;

    /**
     * 获取当前板块所属文章
     *
     * @param sectionId 板块id
     * @param pn        页码
     * @return 文章列表
     */
    @RequestMapping("/getSection")
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getArticle(@RequestParam("sectionId") Integer sectionId,
                                @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 5);
        List<Article> list = homeService.getArticle(sectionId, "all");
        PageInfo pageInfo = new PageInfo(list, 10);
        return ReturnMsg.success().add("pageInfo", pageInfo);
    }
}
