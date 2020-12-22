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

    int updateSort(@Param("id") Integer id, @Param("newSort") Integer newSort);
}