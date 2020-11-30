package cn.edu.hzvtc.service.impl;

import cn.edu.hzvtc.dao.ArticleMapper;
import cn.edu.hzvtc.pojo.Article;
import cn.edu.hzvtc.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kiko
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    public ArticleMapper articleMapper;

    @Override
    public Article getArticleById(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public Long getArtCount() {
        return articleMapper.getArtCount();
    }

    @Override
    public Long getArtSightCount() {
        return articleMapper.getArtSightCount();
    }

    @Override
    public int addSight(Integer id) {
        return articleMapper.addSightByPrimaryKey(id);
    }
}
