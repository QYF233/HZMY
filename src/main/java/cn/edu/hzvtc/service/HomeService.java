package cn.edu.hzvtc.service;

import cn.edu.hzvtc.pojo.Article;
import cn.edu.hzvtc.pojo.Plate;
import cn.edu.hzvtc.pojo.Swiper;

import java.util.List;

/**
 * @author kiko
 */

public interface HomeService {

    public List<Plate> getList();

    public List<Swiper> getSwiper();

    public List<Article> getArticle(Integer id);
}
