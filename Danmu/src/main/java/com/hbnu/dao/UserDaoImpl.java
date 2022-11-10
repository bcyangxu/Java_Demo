package com.hbnu.dao;

import com.hbnu.pojo.User;
import com.hbnu.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDaoImpl implements UserDao{
    @Override
    public User checkUserLogin(String username, String pwd) {
        User user = null;
        Connection conn = DBConnection.getConn();
        ResultSet resultSet = null;
        String sql = "select * from user where id = ? and pwd = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1,username);
            pst.setString(2,pwd);
            resultSet = pst.executeQuery();

            while(resultSet.next()){
                String sno = resultSet.getString("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String sex = resultSet.getString("sex");
                int type = resultSet.getInt("type");
                user = new User(sno,name,age,sex,type);
            }
            DBConnection.close(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public ArrayList<User> showUserList() {
       ArrayList<User> userList = new ArrayList<>();

        Connection conn = new DBConnection().getConn();
        String sql = "select * from user where type = 1";
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();
            while(resultSet.next()){
                String id = resultSet.getString("id");
                String pwd = resultSet.getString("pwd");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String sex = resultSet.getString("sex");
                User user = new User(id,pwd,name,age,sex);
                userList.add(user);

            }
            DBConnection.close(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return userList;

    }

    @Override
    public int deleteUser(int id) {
        int len;
        Connection conn = new DBConnection().getConn();
        String sql = "delete from user where id = ?";
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,id);
            len = pst.executeUpdate();

            DBConnection.close(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return  len;
    }

    @Override
    public User queryUser(int id) {
        User user = null;
        Connection conn = new DBConnection().getConn();
        String sql = "select * from user where id = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setObject(1,id);
            ResultSet resultSet = pst.executeQuery();

              while(resultSet.next()){
                  String sno = resultSet.getString("id");
                  String pwd = resultSet.getString("pwd");
                  String name = resultSet.getString("name");
                  int age = resultSet.getInt("age");
                  String sex = resultSet.getString("sex");
                  user = new User(sno,pwd,name,age,sex);
              }
                DBConnection.close(conn);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public int updateStu(User user, int id) {
        int len = 0;
        Connection con = DBConnection.getConn();
        String sql = "update user set name = ?,age = ?,sex = ? where id = ?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setObject(1, user.getName());
            pst.setObject(2, user.getAge());
            pst.setObject(3, user.getSex());
            pst.setObject(4,id);
            len = pst.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        DBConnection.close(con);
        return len;
    }

    @Override
    public int updateUser(User user, int id) {
        int len;
        Connection con = DBConnection.getConn();
        String sql = "update user set pwd = ?,name = ?,age = ?,sex = ? where id = ?";
        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setObject(1,user.getPwd());
            pst.setObject(2, user.getName());
            pst.setObject(3, user.getAge());
            pst.setObject(4, user.getSex());
            pst.setObject(5,id);
            len = pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        DBConnection.close(con);
        return len;
    }

    @Override
    public int addUser(User stu) {
        int len;
        Connection conn = new DBConnection().getConn();
        String sql = "insert into user values(?,?,?,?,?,?)";
        try {
            PreparedStatement pst = null;
            pst = conn.prepareStatement(sql);
            pst.setString(1,stu.getSno());
            pst.setString(2,stu.getPwd());
            pst.setString(3,stu.getName());
            pst.setInt(4,stu.getAge());
            pst.setString(5,stu.getSex());
            pst.setInt(6,stu.getType());
            len = pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        DBConnection.close(conn);
        return  len;
    }
}
