package cn.edu.hzvtc.service.impl;

import cn.edu.hzvtc.dao.ArticleMapper;
import cn.edu.hzvtc.pojo.Article;
import cn.edu.hzvtc.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Article> getArticle(Integer sectionId) {
        return articleMapper.selectByPlateIdAll(sectionId);
    }

    @Override
    public int addArticle(Article article) {
        return articleMapper.insert(article);
    }

    @Override
    public boolean delArt(String ids) {
        boolean result = false;
        if (ids.contains("-")) {
            /*批量删除*/
            List<Integer> delIds = new ArrayList<>();
            String[] strIds = ids.split("-");
            for (String strId : strIds) {
                delIds.add(Integer.parseInt(strId));
            }
            if (articleMapper.deleteByIdList(delIds) > 0) {
                result = true;
            }
        } else {
            /*单一删除*/
            Integer id = Integer.parseInt(ids);
            if (articleMapper.selectByPrimaryKey(id) != null) {
                if (articleMapper.deleteById(id) > 0) {
                    result = true;
                }
            }
        }
        return result;
    }
}
