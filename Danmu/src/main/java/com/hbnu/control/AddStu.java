package com.hbnu.control;

import com.hbnu.dao.UserDao;
import com.hbnu.dao.UserDaoImpl;
import com.hbnu.pojo.User;

import java.util.Scanner;

public class AddStu {
    public static void addStu()  {
        UserDao dao = new UserDaoImpl();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入新增学生信息(学号、姓名、年龄、性别):");
        String id = sc.next();
        String name = sc.next();
        int age = sc.nextInt();
        String sex = sc.next();
        int type = 1;
        //默认密码123456
        String pwd = "123456";
        User user = new User(id,pwd,name,age,sex,type);
        int len = dao.addUser(user);
        if (len > 0) System.out.println("添加成功");
    }
}
