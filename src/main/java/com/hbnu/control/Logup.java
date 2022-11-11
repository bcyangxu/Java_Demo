package com.hbnu.control;

import com.hbnu.dao.UserDao;
import com.hbnu.dao.UserDaoImpl;
import com.hbnu.pojo.User;

import java.sql.SQLException;
import java.util.Scanner;

public class Logup {
    public static void reg()  {
        System.out.println("请输入学号、密码、姓名、年龄、性别");
        Scanner sc = new Scanner(System.in);
        //接受输入信息
        String sno = sc.next();
        String pwd = sc.next();
        String name = sc.next();
        int age = sc.nextInt();
        String sex = sc.next();
        //注册默认类型为1，学生
        int type = 1;
        User stu = new User(sno,pwd,name,age,sex,type);
        UserDao dao = new UserDaoImpl();
        int len = dao.addUser(stu);
        if (len > 0){
            System.out.println("注册成功");
        }
    }
}
