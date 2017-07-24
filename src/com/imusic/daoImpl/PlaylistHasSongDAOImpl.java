package com.imusic.daoImpl;

import com.imusic.bean.Song;
import com.imusic.dao.PlaylistHasSongDAO;
import com.imusic.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pan on 17-7-24.
 */
public class PlaylistHasSongDAOImpl implements PlaylistHasSongDAO{

    @Override
    public void addSongIntoPlaylist(int playlistID, int songID) {
        String addSQL = "insert into playlistHasSong values(?, ?)";
        dateOperate(playlistID, songID, addSQL);
    }

    @Override
    public void delSongFromPlaylist(int playlistID, int songID) {
        String delSQL = "delete from playlistHasSong " +
                "where playlistID = ? and songID = ?";
        dateOperate(playlistID, songID, delSQL);
    }

    @Override
    public List<Song> findAllSong(int playlistID) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String findAllSongSQL = "select * from song where songID in " +
                "(select songID from playlistHasSong where playlistID = ?)"; // 用于显示指定歌单中所有的歌曲
        ResultSet rs = null;
        List<Song> songList = null;
        try {
            pstmt = conn.prepareStatement(findAllSongSQL);
            pstmt.setInt(1, playlistID);
            rs = pstmt.executeQuery();
            songList = new ArrayList<>();
            while (rs.next()) {
                songList.add(new Song(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
            }
            return songList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, pstmt, conn);
        }
        return null;
    }

    /**
     * 为了避免代码冗余
     * @param playlistID
     * @param songID
     * @param sql
     */
    public void dateOperate(int playlistID, int songID, String sql) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, playlistID);
            pstmt.setInt(2, songID);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt, conn);
        }
    }
}
