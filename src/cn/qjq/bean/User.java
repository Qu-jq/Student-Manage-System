package cn.qjq.bean;

/**
 * 用户类
 * Created by qjq on 2020/2/2 16:12
 */
@SuppressWarnings("all")
public class User {
    private int id;//用户id
    private String uname;//用户名
    private String upass;//用户密码
    private int type;//用户类型 1：管理员 2：学生

    public User() {
    }

    public User(String uname, String upass) {
        this.uname = uname;
        this.upass = upass;
    }

    public User(String uname, String upass, int type) {
        this.uname = uname;
        this.upass = upass;
        this.type = type;
    }

    public User(int id, String uname, String upass, int type) {
        this.id = id;
        this.uname = uname;
        this.upass = upass;
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", upass='" + upass + '\'' +
                ", type=" + type +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
