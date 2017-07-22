package com.imusic.daoImpl;

import com.imusic.bean.SongCommentReply;
import com.imusic.dao.SongCommentReplyDAO;
import com.imusic.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by pan on 17-7-22.
 *
 * 道理同SongCommentDAOImpl
 */
public class SongCommentReplyDAOImpl implements SongCommentReplyDAO {
    @Override
    public void addSongCommentReply(SongCommentReply sCReply) {

    }

    @Override
    public void deleteSongCommentReply(SongCommentReply sCReply) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String delSCReplySQL = "delete from songCommentReply where sCReplyID = ?";
        try {
            pstmt = conn.prepareStatement(delSCReplySQL);
            pstmt.setInt(1, sCReply.getsCReplyID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt, conn);
        }
    }

    @Override
    public void updateSongComment(SongCommentReply sCReply) {

    }

    @Override
    public List<SongCommentReply> findAllSongCommentReply() {
        return null;
    }

    @Override
    public SongCommentReply findSongCommentReplyByID(int sCReplyID) {
        return null;
    }
}
