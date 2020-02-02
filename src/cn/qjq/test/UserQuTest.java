package cn.qjq.test;

import cn.qjq.bean.User;
import cn.qjq.myManage.UserQU_imp;

/**
 * Created by qjq on 2020/2/2 20:34
 */
public class UserQuTest {
    public static void loginTest(){
        UserQU_imp u = new UserQU_imp();
        User user = new User("xiaoqu","xiaoqu");
        System.out.println(u.login(user));
    }

    public static void main(String[] args) {
        loginTest();
    }
}
