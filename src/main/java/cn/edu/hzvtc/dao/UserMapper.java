package cn.edu.hzvtc.dao;

import cn.edu.hzvtc.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author kiko
 */
public interface UserMapper {
    /**
     * 删除用户
     *
     * @param id 用户id
     * @return 更新条数
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加用户
     *
     * @param record 用户信息
     * @return 更新条数
     */
    int insert(User record);

    /**
     * 根据id获取用户信息
     *
     * @param id 用户id
     * @return 用户
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 获取所有用户信息
     *
     * @return 用户列表
     */
    List<User> selectAll();

    /**
     * 更新用户信息
     *
     * @param record 用户信息
     * @return 更新条数
     */
    int updateByPrimaryKey(User record);

    /**
     * 登录匹配用户
     *
     * @param userName     用户名
     * @param userPassword 密码
     * @return 用户信息
     */
    User selectUser(@Param("userName") String userName, @Param("userPassword") String userPassword);

    /**
     * 获取注册用户数
     *
     * @return 用户数
     */
    Long getUserCount();


    int deleteById(Integer id);
    int deleteByIdList(List<Integer> ids);
}