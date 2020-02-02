package cn.qjq.test;

import cn.qjq.bean.User;
import cn.qjq.view.View;

/**
 * Created by qjq on 2020/2/2 16:35
 */
public class ViewTest {
    public static void indexViewTest(){
        User user = View.indexView();
        System.out.println(user.toString());
    }

    public static void managerMenuViewTest(){
        System.out.println(View.managerMenuView());
    }

    public static void main(String[] args) {
        //indexViewTest();//首页测试
        managerMenuViewTest();//管理界面测试

    }
}
