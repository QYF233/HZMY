package cn.edu.hzvtc.service.impl;

import cn.edu.hzvtc.dao.UserMapper;
import cn.edu.hzvtc.pojo.User;
import cn.edu.hzvtc.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<User> getUsers() {
        return userMapper.selectAll();
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    @Override
    public boolean delUser(String ids) {
        boolean result = false;
        if (ids.contains("-")) {
            /*批量删除*/
            List<Integer> delIds = new ArrayList<>();
            String[] strIds = ids.split("-");
            for (String strId : strIds) {
                delIds.add(Integer.parseInt(strId));
            }
            if (userMapper.deleteByIdList(delIds) > 0) {
                result = true;
            }
        } else {
            /*单一删除*/
            Integer id = Integer.parseInt(ids);
            if (userMapper.selectByPrimaryKey(id) != null) {
                if (userMapper.deleteById(id) > 0) {

                    result = true;
                }
            }
        }
        return result;
    }
}
