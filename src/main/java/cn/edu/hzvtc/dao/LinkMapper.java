package cn.edu.hzvtc.dao;

import cn.edu.hzvtc.pojo.Link;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author kiko
 */
public interface LinkMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Link record);

    Link selectByPrimaryKey(Integer id);

    List<Link> selectAll();

    int updateByPrimaryKey(Link record);

    /**
     * 更新友联顺序
     * @param id 友联id
     * @param newSort 新的排序
     * @return
     */
    int updateSort(@Param("id") Integer id, @Param("newSort") Integer newSort);
}