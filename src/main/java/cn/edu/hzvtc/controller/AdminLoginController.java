package cn.edu.hzvtc.controller;

import cn.edu.hzvtc.pojo.User;
import cn.edu.hzvtc.service.AdminUserService;
import cn.edu.hzvtc.tools.JwtUtil;
import cn.edu.hzvtc.tools.ReturnMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 登录、注销、忘记密码
 */
@Controller
@RequestMapping("/login")
public class AdminLoginController {

    @Autowired
    private AdminUserService adminUserService;

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "SignIn", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg login(@RequestParam("loginUsername") String username,
                           @RequestParam("loginPassword") String password) {
        User user = adminUserService.getUser(username, password);
        ReturnMsg returnMsg;
        if (user != null) {
            String token = JwtUtil.sign(user.getId().toString());
//            System.out.println(user.toString());
            returnMsg = ReturnMsg.success().add("token", token).add("user", user);
            returnMsg.setTarget("index.html");
        } else {
            returnMsg = ReturnMsg.fail().add("errorMsg", "账号密码错误");
        }
        return returnMsg;
    }

    /**
     * 注销
     *
     * @return
     */
    @RequestMapping(value = "logout")
    @ResponseBody
    @CrossOrigin
    public ReturnMsg logout() {
        ReturnMsg returnMsg = ReturnMsg.success().add("token", "");
        returnMsg.setTarget("login.html");
        return returnMsg;
    }

    /**
     * 获取user列表
     *
     * @return
     */
    @RequestMapping(value = "getUserList")
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getUserList() {
        List<User> users = adminUserService.getUsers();
        return ReturnMsg.success().add("users", users);
    }

    /**
     * 修改前获取数据
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "getUserById")
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getUserById(@RequestParam("id") Integer id) {
        User user = adminUserService.getUserById(id);
        return ReturnMsg.success().add("user", user);
    }

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "updateUser", method = RequestMethod.PUT)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg updateUser(@Valid User user) {
        System.out.println(user.toString());
        if (adminUserService.updateUser(user) > 0) {
            return ReturnMsg.success();
        }
        return ReturnMsg.fail();
    }

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg addUser(@Valid User user) {
        System.out.println(user.toString());
        if (adminUserService.addUser(user) > 0) {
            return ReturnMsg.success();
        }
        return ReturnMsg.fail();
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "delUser", method = RequestMethod.DELETE)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg delUser(@RequestParam("id") String id) {
        if (adminUserService.delUser(id)) {
            return ReturnMsg.success();
        }
        return ReturnMsg.fail();
    }

    /**
     * 批量删除
     *
     * @param ids 删除id列表
     * @return
     */
    @RequestMapping(value = "/delUser/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public ReturnMsg delArtAll(@PathVariable("ids") String ids) {
        if (adminUserService.delUser(ids)) {
            return ReturnMsg.success();
        }
        return ReturnMsg.fail();
    }
}
