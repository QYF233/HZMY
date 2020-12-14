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
    public Article getArticleById(Integer id);

    /**
     * 获取文章总数
     *
     * @return
     */
    public Long getArtCount();

    /**
     * 获取所有浏览总数
     *
     * @return
     */
    public Long getArtSightCount();

    /**
     * 增加浏览次数
     *
     * @param id 文章id
     * @return
     */
    public int addSight(Integer id);

    /**
     * 获取所有文章列表
     *
     * @param sectionId
     * @return
     */
    public List<Article> getArticle(Integer sectionId,String search);

    /**
     * 添加文章
     *
     * @param article
     * @return
     */
    public int addArticle(Article article);

    /**
     * 删除
     *
     * @param ids
     * @return
     */
    public boolean delArt(String ids);

    /**
     * 更新文章
     * @param article
     * @return
     */
    public int updateArt(Article article);
}
