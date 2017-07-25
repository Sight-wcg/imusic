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
        String addUserSQL = "insert into user(userName, password, " +
                "email,registerDate,lastLoginDate) values(?, ?, ?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(addUserSQL);
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getUserPassword());
            pstmt.setString(3, user.getUserEmail());
            pstmt.setDate(4, (Date)user.getUserRegisterDate());
            pstmt.setDate(5, (Date) user.getUserLastLoginDate());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt, conn);
        }
    }

    /**
     *
     * question: 一个用户的信息可能有处修改，如何判断呢？
     * 虽然可以将用户的所有信息都 set 一遍，但可能会影响性能，而且代码也变多了 :(
     *
     * 考虑了一下，更改用户信息这块只用密码重要性大一点，故将其他都放在updateUser(user)里面
     * 不一定每个字段都会发生改变

     * @param user
     */
    @Override
    public void updateUser(User user) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String updateUserSQL = "update user set userName = ?, email = ?, gender = ?," +
                "birthday = ?, address = ?, headImage = ?, description = ?, phoneNumber = ?";
        try {
            pstmt = conn.prepareStatement(updateUserSQL);
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getUserEmail());
            pstmt.setInt(3, user.getUserGender());
            pstmt.setDate(4, (Date) user.getUserBirthday());
            pstmt.setString(5, user.getUserAddress());
            pstmt.setString(6, user.getUserHeadPortrait()); // 设置用户头像路径
            pstmt.setString(7, user.getUserDescription());
            pstmt.setString(8, user.getUserPhoneNumber());
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
        List<User> userList = null;
        try {
            pstmt = conn.prepareStatement(findAllUserSQL);
            rs = pstmt.executeQuery();
             userList = new ArrayList<>();
            while (rs.next()) {
                userList.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7),
                        rs.getDate(8), rs.getDate(9), rs.getString(10),
                        rs.getString(11), rs.getString(12), rs.getDate(13)));
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, pstmt, conn);
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
                        rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7),
                        rs.getDate(8), rs.getDate(9), rs.getString(10),
                        rs.getString(11), rs.getString(12), rs.getDate(13));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, pstmt, conn);
        }
        return null;
    }
}
