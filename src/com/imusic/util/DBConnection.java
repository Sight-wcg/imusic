package com.imusic.util;

import java.sql.*;

/**
 * Created by pan on 17-7-21.
 */
public class DBConnection {
    /**
     * 声明常量并赋值，用来获得数据库连接对象
     */
    private static final String DBDriver = "com.mysql.jdbc.Driver";
    private static final String DBURL = "jdbc:mysql://localhost:3306/imusic";
    private static final String DBUser = "root";
    private static final String DBPassword = "123456";

    /**
     * getConnection(): 获得数据库连接对象
     * @return Connection
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DBDriver);	//注册驱动
            conn = DriverManager.getConnection(DBURL,DBUser,DBPassword);
        } catch(ClassNotFoundException e) {	//捕获驱动类无法找到异常
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();	//捕获sql异常
        }
        return conn;
    }

    /**
     * close(): 关闭连接对象
     * @param conn
     */
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close(); //关闭conn连接对象
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * close(): 关闭预处理对象
     * @param psmt
     */
    public static void close(PreparedStatement psmt) {
        if (psmt != null) {
            try {
                psmt.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

