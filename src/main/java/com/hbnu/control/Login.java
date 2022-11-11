package com.hbnu.control;

import com.hbnu.dao.UserDao;
import com.hbnu.dao.UserDaoImpl;
import com.hbnu.pojo.User;
import com.hbnu.view.ShowMenu;

import java.util.Scanner;

public class Login {
    public static void checkLogin(){
        UserDao dao = new UserDaoImpl();
        Scanner sc = new Scanner(System.in);
        //接受收入的账号，密码
        System.out.println("请输入账户（学工号）：");
        String username = sc.next();
        System.out.println("请输入密码：");
        String pwd = sc.next();
        //判断登录
        User user = dao.checkUserLogin(username,pwd);

        if (user != null){
            System.out.println("登陆成功！");
            //登录成功，调用菜单方法,传入user对象
            ShowMenu.showMenu(user);
        }else {
            System.out.println("登陆失败！");
        }


    }
}
