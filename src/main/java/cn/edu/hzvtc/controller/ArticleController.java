package cn.edu.hzvtc.controller;

import cn.edu.hzvtc.pojo.Annex;
import cn.edu.hzvtc.pojo.Article;
import cn.edu.hzvtc.service.AnnexService;
import cn.edu.hzvtc.tools.ReturnMsg;
import cn.edu.hzvtc.service.ArticleService;
import cn.edu.hzvtc.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前台文章详情页
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    public ArticleService articleService;
    @Autowired
    public HomeService homeService;

    @Autowired
    public AnnexService annexService;

    /**
     * 获取文章
     *
     * @param id 板块id
     * @return ReturnMsg
     */
    @RequestMapping("/getArticle")
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getArticle(@RequestParam("id") Integer id) {
        Article article = articleService.getArticleById(id);
        if (article != null) {
            articleService.addSight(id);
        }
        return ReturnMsg.success().add("article", article);
    }

    /**
     * 获取上一页，下一页的文章
     * @param plateId 板块id
     * @param articleId 文章id
     * @return
     */
    @RequestMapping(value = "/getOtherArticle", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getOtherArticle(@RequestParam("plateId") Integer plateId,
                                     @RequestParam("articleId") Integer articleId) {
        List<Article> articles = homeService.getArticle(plateId, "all");
        int index = -1;
        for (int i = 0; i < articles.size(); i++) {
            if (articles.get(i).getId().equals(articleId)) {
                index = i;
            }
        }
//        上一条，下一条
        Article prev = null;
        Article next = null;
        if (index == 0 && articles.size() == 1) {
            System.out.println("空");
        } else if (index == 0 && index < articles.size() - 1) {
            next = articles.get(index + 1);
        } else if (index == articles.size() - 1) {
            prev = articles.get(index - 1);
        } else if (index != -1) {
            prev = articles.get(index - 1);
            next = articles.get(index + 1);
        }
        return ReturnMsg.success().add("articles", articles).add("prev", prev).add("next", next);
    }

    /**
     * 获取附件信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/getFile")
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getFile(@RequestParam("id") Integer id) {
        Annex annex = annexService.getAnnex(id);
        return ReturnMsg.success().add("annex", annex);
    }

    /**
     * 增加下载次数
     *
     * @param id 附件id
     * @return
     */
    @RequestMapping("/addDown")
    @ResponseBody
    @CrossOrigin
    public ReturnMsg addDown(@RequestParam("id") Integer id) {
        int annexDown = annexService.addAnnexDown(id);
        if (annexDown > 0) {
            return ReturnMsg.success();
        } else {
            return ReturnMsg.fail();
        }
    }
}
