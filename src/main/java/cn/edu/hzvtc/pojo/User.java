package cn.edu.hzvtc.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class User {
    private Integer id;

    private String userName;

    private String userPassword;

    private String phone;

    private Integer userDelState;
}