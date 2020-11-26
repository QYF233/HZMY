package cn.edu.hzvtc.dao;

import cn.edu.hzvtc.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User selectUser(@Param("userName") String userName, @Param("userPassword") String userPassword);

    Long getUserCount();
}