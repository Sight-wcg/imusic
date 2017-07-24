package com.imusic.daoImpl;

import com.imusic.bean.SongCommentReply;
import com.imusic.dao.SongCommentReplyDAO;
import com.imusic.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pan on 17-7-22.
 *
 * 道理同SongCommentDAOImpl
 */
public class SongCommentReplyDAOImpl implements SongCommentReplyDAO {
    @Override
    public void addSongCommentReply(SongCommentReply sCReply) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String addSCReplySQL = "insert into song_comment_reply(reply, " +
                "replyDate, userID, commentID) values(?, ?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(addSCReplySQL);
            pstmt.setString(1, sCReply.getsCReplyContent());
            pstmt.setDate(2, (Date) sCReply.getsCReplyDate());
            pstmt.setInt(3, sCReply.getUserID());
            pstmt.setInt(4, sCReply.getsCommentID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt, conn);
        }
    }

    @Override
    public void deleteSongCommentReply(SongCommentReply sCReply) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String delSCReplySQL = "delete from song_comment_reply where replyID = ?";
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

    /**
     * 用于显示指定评论下的回复
     * @param sCommentID
     * @return
     */
    @Override
    public List<SongCommentReply> findAllSongCommentReply(int sCommentID) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String findAllSCReplySQL = "select * from song_comment_reply where commentID = ?";
        ResultSet rs = null;
        List<SongCommentReply> songCommentReplies;
        try {
            pstmt = conn.prepareStatement(findAllSCReplySQL);
            pstmt.setInt(1, sCommentID);
            rs = pstmt.executeQuery();
            songCommentReplies = new ArrayList<>();
            while (rs.next()) {
                songCommentReplies.add(new SongCommentReply(rs.getInt(1), rs.getString(2),
                        rs.getDate(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)));
            }
            return songCommentReplies;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, pstmt, conn);
        }
        return null;
    }

    @Override
    public SongCommentReply findSongCommentReplyByID(int sCReplyID) {
        return null;
    }
}
