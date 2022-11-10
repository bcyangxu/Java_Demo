package com.hbnu.dao;

import com.hbnu.pojo.User;

import java.util.ArrayList;

public interface UserDao {

    public User checkUserLogin(String username,String pwd);
    public ArrayList<User> showUserList();

    public int deleteUser(int id);

    public User queryUser(int id);

    public int updateStu(User user, int id);

    public int updateUser(User user,int id);

    public int addUser(User user);
}
