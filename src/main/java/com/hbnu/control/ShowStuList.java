package com.hbnu.control;

import com.hbnu.dao.UserDao;
import com.hbnu.dao.UserDaoImpl;
import com.hbnu.pojo.User;
import java.util.ArrayList;


public class ShowStuList {
   public static void showUserList(){
       UserDao dao = new UserDaoImpl();
       ArrayList<User> users = dao.showUserList();
       for (User stu: users
            ) {
           System.out.printf("学号：%s\t姓名：%s\t年龄：%s\t性别：%s\n",stu.getSno(),stu.getName(),stu.getAge(),stu.getSex());
       }
   }
}
