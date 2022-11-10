package com.hbnu.control;

import com.hbnu.dao.UserDao;
import com.hbnu.dao.UserDaoImpl;
import com.hbnu.pojo.User;

import java.util.Scanner;

public class UpdateStu {
    public static void updateStu(){
        Scanner sc =  new Scanner(System.in);
        UserDao dao = new UserDaoImpl();
        User user = null;
        System.out.println("请输入要修改学生的学号:");
        int id = sc.nextInt();
        ShowInfo.printInfo(id);
        System.out.println("请输入修改的信息：姓名、年龄、性别");

        String name = sc.next();
        int age = sc.nextInt();
        String sex = sc.next();
        user = new User(name,age,sex);
        int len = dao.updateStu(user,id);

        if (len > 0) System.out.println("修改成功");
    }
}
