package cn.edu.hzvtc.service;

import cn.edu.hzvtc.pojo.Article;
import cn.edu.hzvtc.pojo.Link;
import cn.edu.hzvtc.pojo.Plate;
import cn.edu.hzvtc.pojo.Swiper;

import java.util.List;

/**
 * @author kiko
 */

public interface HomeService {
    /**
     * 获取板块列表
     *
     * @return
     */
    public List<Plate> getList();

    /**
     * 获取轮播图
     *
     * @return
     */
    public List<Article> getSwiper();

    /**
     * 获取文章
     *
     * @param plateId
     * @param state
     * @return
     */
    public List<Article> getArticle(Integer plateId, String state);

    /**
     * 获取友链
     *
     * @return
     */
    public List<Link> getLinks();

}
