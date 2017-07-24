package com.imusic.daoImpl;

import com.imusic.bean.User;
import com.imusic.dao.UserFocusUserDAO;
import com.imusic.util.DBConnection;
import com.imusic.util.DBOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pan on 17-7-24.
 *
 * fromUserID and toUserID 可有提高者自己 get
 * eg: fromUserID = fromUser.getUserID();
 *     toUserID = toUser.getUserID();
 */
public class UserFocusUserDAOImpl implements UserFocusUserDAO {
    /**
     * 至于focusDate可以使用系统当前时间作为默认值
     * @param fromUserID
     * @param toUserID
     */
    @Override
    public void addFocus(int fromUserID, int toUserID) {
        String addFocusSQL = "insert into focus" +
                "(fanID, focusID) values(?, ?)";
        DBOperation.dateOperate(fromUserID, toUserID, addFocusSQL);
    }

    @Override
    public void delFocus(int fromUserID, int toUserID) {
        String delFocusSQL = "delete from focus " +
                "where fanUserID = ? and focusID = ?";
        DBOperation.dateOperate(fromUserID, toUserID, delFocusSQL);
    }

    @Override
    public List<User> findAllUser(int fromUserID) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt;
        String findAllUserSQL = "select * from user where userID in " +
                "(select toUserID form userFocusUser where fromUserID = ?";
        ResultSet rs;
        List<User> userList;
        try {
            pstmt = conn.prepareStatement(findAllUserSQL);
            pstmt.setInt(1, fromUserID);
            rs = pstmt.executeQuery();
            userList = new ArrayList<>();
            while (rs.next()) {
                userList.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getDate(6), rs.getDate(7),
                        rs.getString(8), rs.getString(9), rs.getString(10),
                        rs.getDate(11), rs.getString(12), rs.getInt(13)));
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
