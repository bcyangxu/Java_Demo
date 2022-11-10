package com.hbnu.control;

import com.hbnu.dao.UserDao;
import com.hbnu.dao.UserDaoImpl;
import com.hbnu.pojo.User;

public class ShowInfo {
    /*
    输出个人信息方法，可传入id通过查询方法或者直接解析user对象
     */
    public static void printInfo(int id){
        UserDao dao = new UserDaoImpl();
        User user = dao.queryUser(id);
        System.out.printf("学号：%s\t姓名：%s\t年龄:%d\t性别:%s\n", user.getSno(), user.getName(), user.getAge(), user.getSex());
    }
    public static void printInfo(User user){
        System.out.printf("学号：%s\t姓名：%s\t年龄:%d\t性别:%s\n", user.getSno(), user.getName(), user.getAge(), user.getSex());
    }

}
