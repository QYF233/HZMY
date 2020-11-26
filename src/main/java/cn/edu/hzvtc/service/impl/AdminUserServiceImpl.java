package cn.edu.hzvtc.service.impl;

import cn.edu.hzvtc.dao.UserMapper;
import cn.edu.hzvtc.pojo.User;
import cn.edu.hzvtc.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String username, String password) {
        return userMapper.selectUser(username, password);
    }

    @Override
    public User getUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public Long getUserCount() {
        return userMapper.getUserCount();
    }
}
