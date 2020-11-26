package cn.edu.hzvtc.service;

import cn.edu.hzvtc.pojo.User;

public interface AdminUserService {

    public User getUser(String username, String password);

    public User getUserById(Integer userId);

    public Long getUserCount();
}
