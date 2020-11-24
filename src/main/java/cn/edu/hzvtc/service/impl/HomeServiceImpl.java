package cn.edu.hzvtc.service.impl;

import cn.edu.hzvtc.dao.ArticleMapper;
import cn.edu.hzvtc.dao.PlateMapper;
import cn.edu.hzvtc.dao.SwiperMapper;
import cn.edu.hzvtc.pojo.Article;
import cn.edu.hzvtc.pojo.Plate;
import cn.edu.hzvtc.pojo.Swiper;
import cn.edu.hzvtc.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kiko
 */
@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    public PlateMapper plateMapper;

    @Autowired
    public SwiperMapper swiperMapper;

    @Autowired
    public ArticleMapper articleMapper;

    @Override
    public List<Plate> getList() {
        return plateMapper.selectAll();
    }

    @Override
    public List<Swiper> getSwiper() {
        return swiperMapper.selectAll();
    }

    @Override
    public List<Article> getArticle(Integer id) {
        return articleMapper.selectByPlateId(id);
    }
}
