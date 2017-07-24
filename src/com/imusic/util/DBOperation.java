package com.imusic.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by pan on 17-7-24.
 *
 * 用于数据库操作
 */
public class DBOperation {

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
