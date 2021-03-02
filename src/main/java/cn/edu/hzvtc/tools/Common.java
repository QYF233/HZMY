package cn.edu.hzvtc.tools;

public class Common {

    public String chosenEnv() {
        String env = "dev";
        if ("dev".equals(env.toLowerCase())) {
            //开发
            return "D:/DEV/nginx-1.18.0/html/com/";
        } else {
            //生产环境
            return "C:/Program Files/nginx-1.18.0/html/com/";
        }
    }
}
