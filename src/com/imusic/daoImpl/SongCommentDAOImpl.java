package com.imusic.daoImpl;

import com.imusic.bean.SongComment;
import com.imusic.dao.SongCommentDAO;
import com.imusic.util.DBConnection;
import com.imusic.util.DBOperation;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pan on 17-7-22.
 *
 * 主要就是添加评论、删除评论以及显示该歌曲下的所有评论
 *
 * 剩下的都是次要的
 */
public class SongCommentDAOImpl implements SongCommentDAO {
    /**
     * 用户发表对歌单的评论
     *
     * 注意： userID、songID都由sComment提供者自己设置，不再像 playlistDAO (那样是不好的)
     * @param sComment
     */
    @Override
    public void addSongComment(SongComment sComment) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String addSCommentSQL = "insert into song_comment(comment, " +
                "commentDate, userID, songID) values(?,?,?,?)";
        try {
            pstmt = conn.prepareStatement(addSCommentSQL);
            pstmt.setString(1, sComment.getsCommentContent());
            pstmt.setDate(2, (Date) sComment.getsCommentDate());
            pstmt.setInt(3, sComment.getUserID());
            pstmt.setInt(4, sComment.getSongID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt, conn);
        }
    }

    @Override
    public void deleteSongComment(SongComment sComment) {
        int id = sComment.getsCommentID();
        String delSongCommentSQL = "delete from song_comment where commentID = ?";
        DBOperation.deleteItem(id, delSongCommentSQL);
    }

    @Override
    public void updateSongComment(SongComment sComment) { }

    /**
     * 显示特定歌曲下的所有评论
     *
     * @return
     */
    @Override
    public List<SongComment> findAllSongComment(int songID) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String findAllSCommentSQL = "select * from song_comment where songID = ?";
        ResultSet rs = null;
        List<SongComment> songComments;
        try {
            pstmt = conn.prepareStatement(findAllSCommentSQL);
            pstmt.setInt(1, songID);
            rs = pstmt.executeQuery();
            songComments = new ArrayList<>();
            while (rs.next()) {
                songComments.add(new SongComment(rs.getInt(1), rs.getString(2),
                        rs.getDate(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)));
            }
            return songComments;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, pstmt, conn);
        }
        return null;
    }

    @Override
    public SongComment findSongCommentByID(int sCommentID) {
        return null;
    }
}
