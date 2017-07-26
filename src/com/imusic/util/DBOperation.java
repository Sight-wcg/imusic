package com.imusic.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pan on 17-7-24.
 *
 * 用于数据库操作
 */
public class DBOperation {

    /**
     * 根据 id 删除 item
     * @param id
     * @param delSQL
     */
    public static void deleteItem(int id, String delSQL) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(delSQL);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt, conn);
        }
    }

//    /**
//     * 用于查找所有的item
//     *
//     * 无法解决的问题：每个item不一样，构造函数不一样，无法统一用共同的方法
//     * @param findALlItemSQL
//     * @return
//     */
//    public static List<Object> findAllItem(String findALlItemSQL) {
//        Connection conn = DBConnection.getConnection();
//        PreparedStatement pstmt = null;
//        ResultSet rs = null;
//        List<Object> lists = null;
//        try {
//            pstmt = conn.prepareStatement(findALlItemSQL);
//            rs = pstmt.executeQuery();
//            lists = new ArrayList<>();
//            while (rs.next()) {
//                lists.add(new Object());
//            }
//            return lists;
//        } catch(SQLException e) {
//            e.printStackTrace();
//        } finally {
//            DBConnection.close(rs, pstmt, conn);
//        }
//        return null;
//    }

    /**
     * 用于 playlistHasSong & userFocusUser
     * @param aID
     * @param bID
     * @param sql
     */
    public static void dateOperate(int aID, int bID, String sql) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, aID);
            pstmt.setInt(2, bID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt, conn);
        }
    }
}
