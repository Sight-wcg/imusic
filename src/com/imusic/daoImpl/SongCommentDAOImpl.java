package com.imusic.daoImpl;

import com.imusic.bean.SongComment;
import com.imusic.dao.SongCommentDAO;
import com.imusic.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by pan on 17-7-22.
 *
 * 主要就是添加评论与删除评论
 *
 * unfinished
 */
public class SongCommentDAOImpl implements SongCommentDAO {
    @Override
    public void addSongComment(SongComment sComment) {

    }

    @Override
    public void deleteSongComment(SongComment sComment) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String delSongCommentSQL = "delete from songComment where sCommentID = ?";
        try {
            pstmt = conn.prepareStatement(delSongCommentSQL);
            pstmt.setInt(1, sComment.getsCommentID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt, conn);
        }
    }

    @Override
    public void updateSongComment(SongComment sComment) {

    }

    @Override
    public List<SongComment> findAllSongComment() {
        return null;
    }

    @Override
    public SongComment findSongCommentByID(int sCommentID) {
        return null;
    }
}
