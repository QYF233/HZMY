package cn.edu.hzvtc.service;

import cn.edu.hzvtc.pojo.User;

import java.util.List;

public interface AdminUserService {

    public User getUser(String username, String password);

    public User getUserById(Integer userId);

    public Long getUserCount();

    public List<User> getUsers();

    public int updateUser(User user);

    public int addUser(User user);

    public boolean delUser(String id);
}
