package com.hbnu.control;

import com.hbnu.dao.UserDao;
import com.hbnu.dao.UserDaoImpl;
import com.hbnu.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteStu {
    public static void deleteStu()  {
        UserDao dao = new UserDaoImpl();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除的学生学号");
        int id = sc.nextInt();
        int len = dao.deleteUser(id);
        if (len > 0) System.out.println("删除成功");
    }
}
