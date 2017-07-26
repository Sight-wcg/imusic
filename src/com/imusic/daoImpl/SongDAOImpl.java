package com.imusic.daoImpl;

import com.imusic.bean.Song;
import com.imusic.dao.SongDAO;
import com.imusic.util.DBConnection;
import com.imusic.util.DBOperation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pan on 17-7-22.
 *
 * unfinished: 添加歌曲，更新歌曲（需要知道确切的实际操作信息）
 */
public class SongDAOImpl implements SongDAO {
    /**
     * 为专辑添加歌曲
     * @param song
     * @param
     */
    @Override
    public void addSong(Song song, int albumID) {

    }

    @Override
    public void deleteSong(Song song) {
        int id = song.getSongID();
        String delSongSQL = "delete from song where songID = ?";
        DBOperation.deleteItem(id, delSongSQL);
    }

    /**
     * 结合user这方面情况，如何更新需要和前端沟通
     * @param song
     */
    @Override
    public void updateSong(Song song) {

    }

    @Override
    public List<Song> findAllSong() {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String findAllSongSQL = "select * from song";
        ResultSet rs = null;
        List<Song> songList = null;
        try {
            pstmt = conn.prepareStatement(findAllSongSQL);
            rs = pstmt.executeQuery();
            songList = new ArrayList<>();
            while (rs.next()) {
                songList.add(new Song(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6),
                        rs.getInt(7), rs.getString(8), rs.getString(9)));
            }
            return songList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, pstmt, conn);
        }

        return null;
    }

    @Override
    public Song findSongByID(int songID) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String findSongByIDSQL = "select * from song where songID = ?";
        ResultSet rs =null;
        try {
            pstmt = conn.prepareStatement(findSongByIDSQL);
            pstmt.setInt(1, songID);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Song(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6),
                        rs.getInt(7), rs.getString(8), rs.getString(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, pstmt, conn);
        }
        return null;
    }
}
