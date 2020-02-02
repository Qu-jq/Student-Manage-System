package cn.qjq.view;

import cn.qjq.bean.User;

import java.util.Scanner;

/**
 * Created by qjq on 2020/2/2 16:11
 */
public class View {
    private static Scanner input = new Scanner(System.in);

    /**
     * 首页界面
     * @return 返回用户
     */
    public static User indexView(){
        System.out.println("***********************************");
        System.out.println("********\t学生信息管理系统\t*******");
        System.out.println("*********\t请根据提示操作\t*******");
        System.out.println("**********\t请输入账号：\t***********");
        String uname = input.nextLine();
        System.out.println("**********\t请输入密码：\t***********");
        String upass = input.nextLine();
        System.out.println("***********************************");
        return new User(uname,upass);
    }

    /**
     * 管理者菜单界面
     * @return 返回操作选项
     */
    public static int managerMenuView(){
        System.out.println("***********************************");
        System.out.println("********\t欢迎管理员回家\t*******");
        System.out.println("*********\t请根据提示操作\t*******");
        System.out.println("**********\t0.退出\t\t***********");
        System.out.println("**********\t1.添加学生信息\t***********");
        System.out.println("**********\t2.删除学生信息\t***********");
        System.out.println("**********\t3.修改学生信息\t***********");
        System.out.println("**********\t4.查询学生信息\t***********");
        boolean flag = true;
        int num = -1;
        while(flag){
            //转换为整型，这里只能使用nextLine，不能使用nextInt，否则会直接跳转到下一个输入
            num = Integer.parseInt(input.nextLine());
            if (num >= 0 && num <= 4) {
                flag = false;//退出循环
                break;
            }
            System.out.println("输入错误，请重新输入：");
        }
        System.out.println("***********************************");
        return num;
    }

    /**
     * 增加用户界面
     * @return 返回增加的用户信息
     */
    public static User addMenuView(){
        System.out.println("***********************************");
        System.out.println("********\t添加用户界面\t*******");
        System.out.println("*********\t请根据提示操作\t*******");
        System.out.println("**********\t请输入账号：\t***********");
        String uname = input.nextLine();
        System.out.println("**********\t请输入密码：\t***********");
        String upass = input.nextLine();
        System.out.println("***********************************");
        return new User(uname,upass);
    }

    /**
     * 删除用户界面
     * @return 返回删除的用户信息
     */
    public static String deleteMenuView(){
        System.out.println("***********************************");
        System.out.println("********\t删除用户界面\t*******");
        System.out.println("*********\t请根据提示操作\t*******");
        System.out.println("**********\t请输入账号：\t***********");
        String uname = input.nextLine();
        System.out.println("***********************************");
        return uname;
    }

    /**
     * 更新修改用户界面
     * @return 返回修改的用户类
     */
    public static User updateMenuView(){
        System.out.println("***********************************");
        System.out.println("********\t修改用户界面\t*******");
        System.out.println("*********\t请根据提示操作\t*******");
        System.out.println("**********\t请输入账号：\t***********");
        String uname = input.nextLine();
        System.out.println("**********\t请输入新密码：\t***********");
        String upass = input.nextLine();
        System.out.println("***********************************");
        return new User(uname,upass);
    }

    /**
     * 查询用户界面
     * @return 返回查询的用户信息
     */
    public static String selectMenuView(){
        System.out.println("***********************************");
        System.out.println("********\t查询用户界面\t*******");
        System.out.println("*********\t请根据提示操作\t*******");
        System.out.println("**********\t请输入查询账号：\t***********");
        String uname = input.nextLine();
        System.out.println("***********************************");
        return uname;
    }

    /**
     * 学生菜单界面
     * @return 返回操作选项
     */
    public static int studentMenuView(){
        System.out.println("***********************************");
        System.out.println("********\t欢迎学生回家\t*******");
        System.out.println("*********\t请根据提示操作\t*******");
        System.out.println("**********\t0.退出\t\t***********");
        System.out.println("**********\t1.修改密码\t***********");
        boolean flag = true;
        int num = -1;
        while(flag){
            num = Integer.parseInt(input.nextLine());
            if (num >= 0 && num <= 1) {
                flag = false;//退出循环
                break;
            }
            System.out.println("输入错误，请重新输入：");
        }
        System.out.println("***********************************");
        return num;
    }
    /**
     * 修改密码界面
     * @return 返回修改的用户类
     */
    public static String alterPassView(){
        System.out.println("***********************************");
        System.out.println("********\t修改密码界面\t*******");
        System.out.println("*********\t请根据提示操作\t*******");
        System.out.println("**********\t请输入新密码：\t***********");
        String upass = input.nextLine();
        System.out.println("***********************************");
        return upass;
    }

}
