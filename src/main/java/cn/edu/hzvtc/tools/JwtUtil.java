package cn.edu.hzvtc.tools;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    /*设定过期时间一天*/
    private static final long EXPIRE_TIME = 24 * 60 * 60 * 1000;
    /*token私钥*/
    private static final String TOKEN_SECRET = "THIS IS HZMY BY KIKO";

    /**
     * 校验tokken是否正确
     *
     * @param token token
     * @return false/true
     */
    public static boolean verify(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            System.out.println("过期时间：" + jwt.getExpiresAt());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获取登录用户属性值
     *
     * @param token token
     * @return false/true
     */
    public static String getUserProperty(String token, String key) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(key).asString();
        } catch (Exception e) {
            return null;
        }
    }

    /*生成签名，过期时间*/
    public static String sign(String userId) {
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            Map<String, Object> header = new HashMap<>(2);
            header.put("typ", "JWT");
            header.put("alg", "HS256");
            /*附带username信息，生成签名*/
            String token = JWT.create()
                    .withHeader(header)
                    .withClaim("userId", userId)
                    .withExpiresAt(date)
                    .sign(algorithm);
            return token;
        } catch (Exception e) {
            return null;
        }

    }
}
