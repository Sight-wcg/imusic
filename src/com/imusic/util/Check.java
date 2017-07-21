package com.imusic.util;
import com.imusic.bean.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Banyuanjun on 2017/7/21 0021.
 */

/*
 * method checkIsExist is used to judge the username exists or not
 */
public class Check {
    public final static Connection conn = DBConnection.getConnection();

    public static boolean checkIsExist(User user) {
        String username = user.getUserName();
        String sql = "select count(userID) from user where userName = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return (Integer.parseInt(rs.getString(1)) == 0);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}

