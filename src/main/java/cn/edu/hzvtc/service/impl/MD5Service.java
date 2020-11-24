package cn.edu.hzvtc.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @author kiko
 */
@Service
public class MD5Service {

    public String toMD5(String str) {
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }
}
