package cn.edu.hzvtc.controller;

import cn.edu.hzvtc.pojo.User;
import cn.edu.hzvtc.service.AdminUserService;
import cn.edu.hzvtc.tools.JwtUtil;
import cn.edu.hzvtc.tools.ReturnMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.*;

/**
 * 登录、注销、忘记密码
 *
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
//    @RequestMapping(value = "SignIn", method = RequestMethod.POST)
//    @ResponseBody
//    @CrossOrigin
//    public ReturnMsg login(@RequestParam("loginUsername") String username,
//                           @RequestParam("loginPassword") String password) {
//        User user = adminUserService.getUser(username, password);
//        ReturnMsg returnMsg;
//        if (user != null) {
//            String token = JwtUtil.sign(user.getId().toString());
//            returnMsg = ReturnMsg.success().add("token", token).add("user", user);
//            returnMsg.setTarget("index.html");
//        } else {
//            returnMsg = ReturnMsg.fail().add("errorMsg", "用户名或密码错误");
//        }
//        return returnMsg;
//    }

    /**
     * @param user
     * @return
     */
    @RequestMapping(value = "SignIn", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg login(@RequestBody User user) {
        ReturnMsg returnMsg = null;

        User userdb = adminUserService.getUser(user.getUsername(), user.getPassword());

        System.out.println(userdb);
        if (userdb != null) {
            String token = JwtUtil.sign(userdb.getId().toString());
            returnMsg = ReturnMsg.success().add("token", token).add("user", user);
            returnMsg.setMessage("登录成功!");
        } else {
            returnMsg = ReturnMsg.fail();
            returnMsg.setMessage("用户名或密码错误");
        }
        return returnMsg;
    }

    @RequestMapping(value = "getLoginUser", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg getLoginUser(@RequestParam("token") String token) {

        System.out.println("token" + token);

        if (!JwtUtil.verify(token)) {
            return ReturnMsg.fail().add("errorMsg", "token无效");
        }
        String userId = JwtUtil.getUserProperty(token, "userId");
        User loginUser = adminUserService.getUserById(Integer.parseInt(userId));

        if (loginUser != null) {
            return ReturnMsg.success().add("name", loginUser.getUsername()).add("roles", "admin")
                    .add("avatar","https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3659769985,3441244409&fm=26&gp=0.jpg");
        } else {
            return ReturnMsg.fail();
        }
    }

    /**
     * 注销
     *
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.POST)
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
    @RequestMapping(value = "updateUser", method = RequestMethod.POST)
    @ResponseBody
    @CrossOrigin
    public ReturnMsg updateUser(@Valid User user) {
//        System.out.println(user.toString());
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
//        System.out.println(user.toString());
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
    @RequestMapping(value = "delUser", method = RequestMethod.POST)
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
    @RequestMapping(value = "/delUser/{ids}", method = RequestMethod.POST)
    @ResponseBody
    public ReturnMsg delArtAll(@PathVariable("ids") String ids) {
        if (adminUserService.delUser(ids)) {
            return ReturnMsg.success();
        }
        return ReturnMsg.fail();
    }

    /**
     * 验证用户名是否存在
     *
     * @param name 用户名
     * @return
     */
    @RequestMapping(value = "/validName", method = RequestMethod.GET)
    @ResponseBody
    public ReturnMsg validName(@RequestParam("name") String name) {
        User user = adminUserService.getUserByName(name);
        if (user != null) {
            return ReturnMsg.success().add("user", user);
        }
        return ReturnMsg.fail();
    }

    /**
     * 验证手机号
     *
     * @param phone
     * @return
     */
    @RequestMapping(value = "/validPhone", method = RequestMethod.GET)
    @ResponseBody
    public ReturnMsg validPhone(@RequestParam("phone") String phone) {
        User user = adminUserService.getUserByPhone(phone);
        if (user != null) {
            return ReturnMsg.success().add("user", user);
        }
        return ReturnMsg.fail();
    }
}
