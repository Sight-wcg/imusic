package com.imusic.daoImpl;

import com.imusic.bean.Playlist;
import com.imusic.dao.PlaylistDAO;
import com.imusic.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pan on 17-7-22.
 *
 * 道理同SongDAOImpl
 */
public class PlaylistDAOImpl implements PlaylistDAO {
    @Override
    public void addPlaylist(Playlist playlist, int userID) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        /**
         * 创建歌单时获得创建者，填入歌单名，歌单描述，歌单图片等
         */
        String addPlaylistSQL = "insert into playlist(userID, playlistName, playlistDescription, " +
                "playlistImg) values(?, ?, ?, ?)";
        try {
            pstmt = conn.prepareStatement(addPlaylistSQL);
            pstmt.setInt(1, userID);
            pstmt.setString(2, playlist.getPlaylistName());
            pstmt.setString(3, playlist.getPlaylistDescription());
            pstmt.setString(4, playlist.getPlaylistImg());  // 设置图片路径
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt, conn);
        }
    }

    @Override
    public void deletePlaylist(Playlist playlist) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String delPlaylistSQL = "delete from playlist where playlistID = ?";
        try {
            pstmt = conn.prepareStatement(delPlaylistSQL);
            pstmt.setInt(1, playlist.getPlaylistID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt, conn);
        }
    }

    /**
     * 默认更新歌单名字，歌单描述，歌单图片
     * @param playlist
     */
    @Override
    public void updatePlaylist(Playlist playlist) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String updatePlaylistSQL = "update playlist set playlistName = ?, " +
                "playlistDescription = ?, playlistImg = ? where playlistID = ?";
        try {
            pstmt = conn.prepareStatement(updatePlaylistSQL);
            pstmt.setString(1, playlist.getPlaylistName());
            pstmt.setString(2, playlist.getPlaylistDescription());
            pstmt.setString(3, playlist.getPlaylistImg());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt, conn);
        }
    }

    @Override
    public List<Playlist> findAllPlaylist() {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String findAllPlaylistSQL = "select * from playlist";
        ResultSet rs = null;
        List<Playlist> playlists = null;
        try {
            pstmt = conn.prepareStatement(findAllPlaylistSQL);
            rs = pstmt.executeQuery();
            playlists = new ArrayList<>();
            while (rs.next()) {
                playlists.add(new Playlist(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getDate(6)));
            }
            return playlists;
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, pstmt, conn);
        }
        return null;
    }

    @Override
    public Playlist findPlaylistByID(int playlistID) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String findPlaylistByIDSQL = "select * from playlist where playlistID = ?";
        ResultSet rs =null;
        try {
            pstmt = conn.prepareStatement(findPlaylistByIDSQL);
            pstmt.setInt(1, playlistID);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Playlist(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getDate(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, pstmt, conn);
        }
        return null;
    }
}
