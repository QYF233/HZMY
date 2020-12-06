package cn.edu.hzvtc.service.impl;

import cn.edu.hzvtc.dao.AnnexMapper;
import cn.edu.hzvtc.dao.ArticleMapper;
import cn.edu.hzvtc.pojo.Article;
import cn.edu.hzvtc.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author kiko
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    public ArticleMapper articleMapper;
    @Autowired
    public AnnexMapper annexMapper;

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
                //删除后获取删除的文件列表
                List<Article> articleList = articleMapper.selectDelFileList(delIds);
                //根据文件列表进行遍历
                for (Article article : articleList) {
                    //获取删除的文章的附件列表
                    String[] fileList = article.getArtFileId().split("-");
                    List<Integer> fileIds = Arrays.stream(fileList)
                            .map(s -> Integer.parseInt(s.trim()))
                            .collect(Collectors.toList());
                    annexMapper.deleteAnnexByList(fileIds);
                }
                result = true;
            }
        } else {
            /*单一删除*/
            Integer id = Integer.parseInt(ids);
            Article article = articleMapper.selectByPrimaryKey(id);
            if (article != null) {
                String[] fileList = article.getArtFileId().split("-");
                if (articleMapper.deleteById(id) > 0) {
                    List<Integer> fileIds = Arrays.stream(fileList)
                            .map(s -> Integer.parseInt(s.trim()))
                            .collect(Collectors.toList());
                    annexMapper.deleteAnnexByList(fileIds);
                    result = true;
                }
            }
        }
        return result;
    }
}
