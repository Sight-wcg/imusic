package com.imusic.daoImpl;

import com.imusic.bean.PlaylistComment;
import com.imusic.dao.PlaylistCommentDAO;
import com.imusic.util.DBConnection;
import com.imusic.util.DBOperation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pan on 17-7-22.
 *
 * 道理同SongCommentDAOImpl
 */
public class PlaylistCommentDAOImpl implements PlaylistCommentDAO {
    @Override
    public void addPlaylistComment(PlaylistComment playlistComment) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String addPCommnetSQL = "insert into list_comment(listComment, listCommentDate," +
                " userID, listID values(?, ?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(addPCommnetSQL);
            pstmt.setString(1, playlistComment.getpCommentContent());
            pstmt.setDate(2, (Date) playlistComment.getpCommentDate());
            pstmt.setInt(3, playlistComment.getUserID());
            pstmt.setInt(4, playlistComment.getPlaylistID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt, conn);
        }
    }

    @Override
    public void deletePlaylistComment(PlaylistComment playlistComment) {
        int id = playlistComment.getpCommentID();
        String delPCommentSQL = "delete from list_comment where listCommentID = ?";
        DBOperation.deleteItem(id, delPCommentSQL);
    }

    @Override
    public void updatePlaylistComment(PlaylistComment playlistComment) {

    }

    @Override
    public List<PlaylistComment> findAllPlaylistComment(int playlistID) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String findAllPCommentSQL = "select * from listComment where listID = ?";
        ResultSet rs = null;
        List<PlaylistComment> playlistComments = null;
        try {
            pstmt = conn.prepareStatement(findAllPCommentSQL);
            pstmt.setInt(1, playlistID);
            rs = pstmt.executeQuery();
            playlistComments = new ArrayList<>();
            if (rs.next()) {
                playlistComments.add(new PlaylistComment(rs.getInt(1), rs.getString(2),
                        rs.getDate(3), rs.getInt(4), rs.getInt(5), rs.getInt(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, pstmt, conn);
        }
        return null;
    }

    @Override
    public PlaylistComment findPlaylistCommentByID(int pCommentID) {
        return null;
    }
}
