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
    public Article getArticleById(Integer id);
    public Long getArtCount();
}
