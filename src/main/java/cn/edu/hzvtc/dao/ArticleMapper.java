package cn.edu.hzvtc.dao;

import cn.edu.hzvtc.pojo.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author kiko
 */
public interface ArticleMapper {
    /**
     * 更具id修改文章
     *
     * @param id 文章id
     * @return 更新条数
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加文章
     *
     * @param record 文章信息
     * @return 更新条数
     */
    int insert(Article record);

    /**
     * 根据id获得文章详情
     *
     * @param id 文章id
     * @return 文章
     */
    Article selectByPrimaryKey(Integer id);

    /**
     * 获取所有文文章
     *
     * @return 文章列表
     */
    List<Article> selectAll();

    /**
     * 更新文章信息
     *
     * @param record 文章对象
     * @return 更新条数
     */
    int updateByPrimaryKey(Article record);

    /**
     * 获取首页展示的5条文章
     *
     * @param id 板块id
     * @return 文章列表
     */
    List<Article> selectByPlateId(Integer id);

    /**
     * 获取当前板块下的所有文章
     *
     * @param id 板块id
     * @return 文章列表
     */
    List<Article> selectByPlateIdAll(@Param("id") Integer id, @Param("search") String search);

    /**
     * 后台获取文章列表，按发布时间
     *
     * @param id
     * @param search
     * @return
     */
    List<Article> selectAllArticle(@Param("id") Integer id, @Param("search") String search, @Param("artType") Integer artType);

    /**
     * 获取该板块下的所有文章
     *
     * @param id
     * @return
     */
    List<Article> selectAllByPlateId(Integer id);

    /**
     * 获取文章数量
     *
     * @return 发表文章数
     */
    Long getArtCount();

    /**
     * 获取浏览总数
     *
     * @return 文章总浏览数
     */
    Long getArtSightCount();

    /**
     * 获取板块浏览量
     *
     * @param secId 板块id
     * @return 板块浏览量
     */
    Long getArtSightCountBySec(Integer secId);

    /**
     * 增加文章浏览数
     *
     * @param id 文章id
     * @return 更新数量
     */
    int addSightByPrimaryKey(Integer id);

    /**
     * 删除文章
     *
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    int deleteByIdList(List<Integer> ids);

    /**
     * 获取删除后的附件列表
     *
     * @param id 删除的文章id
     * @return
     */
    List<Article> selectDelFileList(List<Integer> id);

    /**
     * 取消这个板块下所有文章的置顶
     *
     * @param plaId 板块id
     * @return
     */
    int cancelTop(Integer plaId);

    /**
     * 获取轮播图
     *
     * @return
     */
    List<Article> getSwiperList();

    /**
     * 获取学院介绍
     *
     * @return
     */
    Article getIntro();

    /**
     * 更新学院介绍信息
     *
     * @param introText 介绍信息
     * @param picName   图片名
     * @return
     */
    int updateIntro(@Param("introText") String introText, @Param("picName") String picName);
}