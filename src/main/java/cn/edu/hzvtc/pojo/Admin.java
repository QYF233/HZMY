package cn.edu.hzvtc.pojo;

public class Admin {
    private Integer id;

    private String username;

    private String password;

    private Integer phone;

    private Integer adminDelState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getAdminDelState() {
        return adminDelState;
    }

    public void setAdminDelState(Integer adminDelState) {
        this.adminDelState = adminDelState;
    }
}