package cn.edu.hzvtc.interceptor;

import cn.edu.hzvtc.pojo.User;
import cn.edu.hzvtc.service.AdminUserService;
import cn.edu.hzvtc.tools.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 任务31
 * 2020年11月26日【创建】
 */
public class JWTInterceptor implements HandlerInterceptor {

    @Autowired
    public AdminUserService adminUserService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        Boolean flg = true;

        // 获取请求的 RUi ：去除 http:localhost:8080 这部分剩下的
        String uri = request.getRequestURI();
        System.out.println(uri);

        // 获取 token
        String token = "";
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                token = cookie.getValue();
            }
        }
        System.out.println(token);
        if (!token.equals("")) {
            String userId = JwtUtil.getUserProperty(token, "userId");
            User user = null;
            if (userId != null) {
                user = adminUserService.getUserById(Integer.parseInt(userId));
            }
            // 判断 session 中是否有用户数据，如果有，则返回 true ，继续向下执行
            if (user != null) {
                if (uri.indexOf("/admin") >= 0) {
                    flg = true;
                }
            } else {
                flg = false;
            }
        } else {
            flg = false;
        }

        if (!flg) {
            // 不符合条件重定向到登录页面
            response.sendRedirect(request.getContextPath()+"/login.html");
            return false;
        }

        return flg;
    }
}
