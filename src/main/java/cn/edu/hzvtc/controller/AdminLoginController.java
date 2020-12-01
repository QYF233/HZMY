package cn.edu.hzvtc.controller;

import cn.edu.hzvtc.pojo.User;
import cn.edu.hzvtc.service.AdminUserService;
import cn.edu.hzvtc.tools.JwtUtil;
import cn.edu.hzvtc.tools.ReturnMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author kiko
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
            System.out.println(user.toString());
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

}
