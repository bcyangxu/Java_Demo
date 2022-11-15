package com.hbnu.control;

import com.alibaba.excel.EasyExcel;
import com.hbnu.dao.UserDao;
import com.hbnu.dao.UserDaoImpl;
import com.hbnu.pojo.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExportInfo {
    public static void exportUserList(){

        UserDao dao = new UserDaoImpl();
        ArrayList<User> userList = dao.showUserList();
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\test\\list.txt"));
            //遍历集合
            for (User user:userList
                 ) {
                //输出每个user对象的信息
                bw.write(user.getSno());
                bw.write(user.getName());
                bw.write(Integer.toString(user.getAge()));
                bw.write(user.getSex());
                bw.newLine();            //换行
                bw.flush();
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void exportUserListToExcel(){
        UserDao dao = new UserDaoImpl();
        List<User> userList = dao.showUserList();
        String file = "D:\\test\\list.xlsx";
        EasyExcel.write(file,User.class).sheet("info").doWrite(userList);
    }
    public static void exportUserToExcel(int id){
        UserDao dao = new UserDaoImpl();
        User user = dao.queryUser(id);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        String file = "D:\\test\\info.xlsx";
        EasyExcel.write(file,User.class).sheet("list").doWrite(userList);
    }

    public static void exportUser(int id){
        UserDao dao = new UserDaoImpl();
        User user = dao.queryUser(id);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\test\\info.txt"));
            bw.write(user.getSno());
            bw.newLine();
            bw.write(user.getName());
            bw.newLine();
            bw.write(Integer.toString(user.getAge()));
            bw.newLine();
            bw.write(user.getSex());
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
