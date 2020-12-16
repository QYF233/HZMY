package cn.edu.hzvtc.service;

import cn.edu.hzvtc.pojo.User;

import java.util.List;

public interface AdminUserService {
    /**
     * 登录比对用户
     * @param username
     * @param password
     * @return
     */
    public User getUser(String username, String password);
    public User getUserByName(String username);
    public User getUserByPhone(String phone);

    /**
     * 根据id获取用户
     * @param userId
     * @return
     */
    public User getUserById(Integer userId);

    /**
     * 获取用户数
     * @return
     */
    public Long getUserCount();

    /**
     * 获取用户列表
     * @return
     */
    public List<User> getUsers();

    /**
     * 更新用户
     * @param user
     * @return
     */
    public int updateUser(User user);

    /**
     * 添加用户
     * @param user
     * @return
     */
    public int addUser(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    public boolean delUser(String id);
}
