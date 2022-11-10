package com.hbnu.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBConnection {
    private static Connection conn;
    public static  Connection getConn(){
        //读取jdbc配置文件
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        String driver = rb.getString("driver");
        String url = rb.getString("url");
        String user= rb.getString("user");
        String pwd = rb.getString("pwd");

        try {
            //加载驱动
            Class.forName(driver);
            //获取数据库连接
            conn = DriverManager.getConnection(url,user,pwd);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //返回连接对象
        return conn;
    }
    /*
    关闭数据库连接对象方法
     */
    public static void close(Connection conn){
        try {
            if (conn != null|| !conn.isClosed()){
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("DB closed");
    }
}
