package com.hbnu.control;

import com.hbnu.dao.UserDao;
import com.hbnu.dao.UserDaoImpl;
import com.hbnu.pojo.User;

import java.util.Scanner;

public class UpdateUser {
    public static void updateUser(int id){
        Scanner sc = new Scanner(System.in);
        UserDao dao = new UserDaoImpl();
        System.out.println("请输入修改的信息：密码、姓名、年龄、性别");
        String pwd = sc.next();
        String name = sc.next();
        int age = sc.nextInt();
        String sex = sc.next();
        User user = new User(pwd,name,age,sex);
        int len = dao.updateUser(user,id);
        if (len > 0) System.out.println("修改成功");
    }
}
