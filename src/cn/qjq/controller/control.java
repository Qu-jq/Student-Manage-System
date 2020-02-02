package cn.qjq.controller;

import cn.qjq.bean.User;
import cn.qjq.myManage.UserQU_imp;
import cn.qjq.myManage.UserQu;
import cn.qjq.view.View;

/**
 * 程序入口
 * 本学生管理系统采用MVC的设计模式
 * Created by qjq on 2020/2/2 20:21
 */
public class control {
    static UserQU_imp userQu = new UserQU_imp();
    public static void main(String[] args) {
        User user = null;
        int type = -1;
        boolean flag=true;//循环标志位
        while (flag) {
            user = View.indexView();
            type = userQu.login(user);
            switch (type) {
                case -1:
                    System.out.println("登录失败，请重新登录：");
                    break;
                case 1:
                    System.out.println("恭喜管理员登录成功！");
                    managerServer();
                    break;
                case 2:
                    System.out.println("恭喜学生登录成功！");
                    studentServer(user.getUname());
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 管理员控制
     */
    public static void managerServer(){
        boolean flag=true;//循环标志位
        while (flag){
            int choice = View.managerMenuView();//选择操作
            switch (choice){
                case 0:
                    System.out.println("退出系统，再见！");
                    flag=false;
                    break;
                case 1:
                    User newUser = View.addMenuView();
                    if (userQu.insert(newUser)){
                        System.out.println("恭喜添加成功！");
                    }else {
                        System.out.println("插入失败");
                        //
                    }
                    break;
                case 2:
                    String uname = View.deleteMenuView();
                    if (userQu.delete(uname)){
                        System.out.println("恭喜删除成功");
                    }else {
                        System.out.println("删除失败");
                        //
                    }
                    break;
                case 3:
                    User user = View.updateMenuView();
                    if (userQu.update(user)){
                        System.out.println("恭喜修改成功！");
                    }else {
                        System.out.println("修改失败");
                        //
                    }
                    break;
                case 4:
                    String uname2 = View.deleteMenuView();
                    User selectUser = userQu.select(uname2);
                    if (selectUser!=null){
                        System.out.println("您查询的信息如下：");
                        System.out.printf("姓名：%s 密码：%s 用户类型：%d\n",
                                selectUser.getUname(),selectUser.getUpass(),selectUser.getType());
                    }else {
                        System.out.println("查询失败，查无此人");
                    }

                    break;
                default:
                    break;
            }
        }

    }

    /**
     * 学生控制
     * @param uname 学生的账户名
     */
    public static void studentServer(String uname){
        boolean flag=true;//循环标志位
        while (flag){
            int choice = View.studentMenuView();//选择操作
            switch (choice){
                case 0:
                    System.out.println("退出系统，再见！");
                    flag=false;
                    break;
                case 1:
                    String psw = View.alterPassView();
                    if (userQu.update(new User(uname,psw))){
                        System.out.println("恭喜修改密码成功！");
                    }else {
                        System.out.println("修改密码失败！");
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
