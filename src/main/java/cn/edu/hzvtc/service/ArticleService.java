package cn.edu.hzvtc.service;

import cn.edu.hzvtc.pojo.Article;
import cn.edu.hzvtc.pojo.Link;
import cn.edu.hzvtc.pojo.Plate;
import cn.edu.hzvtc.pojo.Swiper;

import java.util.List;

/**
 * @author kiko
 */

public interface ArticleService {
    /**
     * 按id获取文章信息
     *
     * @param id 文章id
     * @return
     */
    Article getArticleById(Integer id);

    /**
     * 获取文章总数
     *
     * @return
     */
    Long getArtCount();

    /**
     * 获取所有浏览总数
     *
     * @return
     */
    Long getArtSightCount();

    /**
     * 增加浏览次数
     *
     * @param id 文章id
     * @return
     */
    int addSight(Integer id);

    /**
     * 获取所有文章列表
     *
     * @param sectionId
     * @return
     */
    List<Article> getArticle(Integer sectionId, String search,boolean pageType);

    /**
     * 添加文章
     *
     * @param article
     * @return
     */
    int addArticle(Article article);

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    boolean delArt(String ids);

    /**
     * 更新文章
     *
     * @param article
     * @return
     */
    int updateArt(Article article);

    /**
     * 取消置顶
     *
     * @param plaId
     * @return
     */
    int cancelTop(Integer plaId);

    Article getIntro();

    /**
     * 更新学院介绍
     *
     * @param introText
     * @param picName
     * @return
     */
    int updateIntro(String introText, String picName);
}
