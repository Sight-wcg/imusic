package com.imusic.daoImpl;

import com.imusic.bean.User;
import com.imusic.dao.UserDAO;
import com.imusic.util.DBConnection;

import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Created by pan on 17-7-21.
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public void addUser(User user) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String addUserSQL = "insert into user(userName, userPassword, " +
                "userEmail,userRegisterDate,userLastLoginDate) values(?, ?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(addUserSQL);
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getUserPassword());
            pstmt.setString(3, user.getUserEmail());
            pstmt.setDate(4, (Date)user.getUserRegisterDate());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt, conn);
        }
    }

    @Override
    public void updateUser(User user) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        /*
         *  question: 一个用户的信息可能有处修改，如何判断呢？
         *  虽然可以将用户的所有信息都 set 一遍，但可能会影响性能，而且代码也变多了 :(
         */
        String updateUserSQL = "alter table user set username = ?";     // 暂时为修改用户名
        try {
            pstmt = conn.prepareStatement(updateUserSQL);
            pstmt.setString(1, user.getUserName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt, conn);
        }

    }

    @Override
    public void deleteUser(User user) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String delUserSQL = "delete from user where userID = ?";
        try {
            pstmt = conn.prepareStatement(delUserSQL);
            pstmt.setInt(1, user.getUserID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt, conn);
        }
    }

    @Override
    public List<User> findAllUser() {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String findAllUserSQL = "select * from user";
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(findAllUserSQL);
            rs = pstmt.executeQuery();
            List<User> userList = new ArrayList<>();
            while (rs.next()) {
                userList.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getDate(7),
                        rs.getString(8), rs.getString(9), rs.getString(10), rs.getDate(11)));
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public User findUserByID(int userID) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String findUserByIDSQL = "select * from user where userID = ?";
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(findUserByIDSQL);
            pstmt.setInt(1, userID);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getDate(7),
                        rs.getString(8), rs.getString(9), rs.getString(10), rs.getDate(11));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, pstmt, conn);
        }
        return null;
    }
}
