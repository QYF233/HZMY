package cn.edu.hzvtc.controller;

import cn.edu.hzvtc.pojo.Article;
import cn.edu.hzvtc.service.ArticleService;
import cn.edu.hzvtc.service.HomeService;
import cn.edu.hzvtc.tools.ReturnMsg;
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
@RequestMapping("/admin/article")
public class AdminArticleController {

    @Autowired
    public ArticleService articleService;

    /**
     * 获取所有文章，0不分板块，按发布时间
     *
     * @param sectionId
     * @param pn
     * @return
     */
    @RequestMapping("/getArticle")
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getArticle(@RequestParam(value = "sectionId", defaultValue = "0") Integer sectionId,
                                @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        PageHelper.startPage(pn, 5);
        List<Article> list = articleService.getArticle(sectionId);
        PageInfo pageInfo = new PageInfo(list, 10);
        return ReturnMsg.success().add("pageInfo", pageInfo);
    }
}
