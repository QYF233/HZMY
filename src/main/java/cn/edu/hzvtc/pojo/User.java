package cn.edu.hzvtc.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author kiko
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {
    private Integer id;

    private String username;

    private String password;

    private String phone;

    private Integer userDelState;
}
