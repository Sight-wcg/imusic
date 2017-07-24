package com.imusic.daoImpl;

import com.imusic.bean.PlaylistCommentReply;
import com.imusic.dao.PlaylistCommentReplyDAO;
import com.imusic.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pan on 17-7-22.
 *
 * 道理同SongCommentDAOImpl
 */
public class PlaylistCommentReplyDAOImpl implements PlaylistCommentReplyDAO {
    @Override
    public void addPlaylistCommentReply(PlaylistCommentReply pCReply) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String addPCReplySQL = "insert into playlistCommentReply(pCReplyContent, pCReplyDate," +
                "userID, pCommentID) values(?, ?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(addPCReplySQL);
            pstmt.setString(1, pCReply.getpCReplyContent());
            pstmt.setDate(2, (Date) pCReply.getpCReplyDate());
            pstmt.setInt(3, pCReply.getUserID());
            pstmt.setInt(4, pCReply.getpCommentID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt, conn);
        }
    }

    @Override
    public void deletePlaylistCommentReply(PlaylistCommentReply pCReply) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String delPCReplySQL = "delete from playlistCommentReply where pCReplyID = ?";
        try {
            pstmt = conn.prepareStatement(delPCReplySQL);
            pstmt.setInt(1, pCReply.getpCReplyID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt, conn);
        }
    }

    @Override
    public void updatePlaylistCommentReply(PlaylistCommentReply pCReply) {

    }

    @Override
    public List<PlaylistCommentReply> findAllPlaylistCommentReply(int pCommentID) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String findAllSCReplySQL = "select * from playlistCommentReply where pCommentID = ?";
        ResultSet rs = null;
        List<PlaylistCommentReply> playlistCommentReplies;
        try {
            pstmt = conn.prepareStatement(findAllSCReplySQL);
            pstmt.setInt(1, pCommentID);
            rs = pstmt.executeQuery();
            playlistCommentReplies = new ArrayList<>();
            while (rs.next()) {
                playlistCommentReplies.add(new PlaylistCommentReply(rs.getInt(1), rs.getString(2),
                        rs.getDate(3), rs.getInt(4), rs.getInt(5)));
            }
            return playlistCommentReplies;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, pstmt, conn);
        }
        return null;
    }

    @Override
    public PlaylistCommentReply findPlaylistCommentReplyByID(int pCReplyID) {
        return null;
    }
}
