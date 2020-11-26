package cn.edu.hzvtc.dao;

import cn.edu.hzvtc.pojo.Article;
import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    Article selectByPrimaryKey(Integer id);

    List<Article> selectAll();

    int updateByPrimaryKey(Article record);

    List<Article> selectByPlateId(Integer id);
    List<Article> selectByPlateIdAll(Integer id);
    Long getArtCount();
}