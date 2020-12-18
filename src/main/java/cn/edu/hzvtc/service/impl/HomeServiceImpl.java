package cn.edu.hzvtc.service.impl;

import cn.edu.hzvtc.dao.ArticleMapper;
import cn.edu.hzvtc.dao.LinkMapper;
import cn.edu.hzvtc.dao.PlateMapper;
import cn.edu.hzvtc.dao.SwiperMapper;
import cn.edu.hzvtc.pojo.Article;
import cn.edu.hzvtc.pojo.Link;
import cn.edu.hzvtc.pojo.Plate;
import cn.edu.hzvtc.pojo.Swiper;
import cn.edu.hzvtc.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
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

    @Autowired
    public LinkMapper linkMapper;

    @Override
    public List<Plate> getList() {
        return plateMapper.selectAll();
    }

    @Override
    public List<Article> getSwiper() {
        return articleMapper.getSwiperList();
    }

    /**
     * 前台列表页获取数据
     *
     * @param plateId
     * @param state
     * @return
     */
    @Override
    public List<Article> getArticle(Integer plateId, String state) {
        if ("all".equals(state)) {
            return articleMapper.selectByPlateIdAll(plateId, "");
        } else {
            return articleMapper.selectByPlateId(plateId);
        }
    }

    @Override
    public List<Link> getLinks() {
        return linkMapper.selectAll();
    }
}
