package com.imusic.daoImpl;

import com.imusic.bean.Playlist;
import com.imusic.dao.PlaylistDAO;
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
        String addPlaylistSQL = "insert into list(creatorID, listName, description, listImg) values(?, ?, ?, ?)";
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
        int id = playlist.getPlaylistID();
        String delPlaylistSQL = "delete from list where listID = ?";
        DBOperation.deleteItem(id, delPlaylistSQL);
    }

    /**
     * 默认更新歌单名字，歌单描述，歌单图片
     * @param playlist
     */
    @Override
    public void updatePlaylist(Playlist playlist) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String updatePlaylistSQL = "update list set listName = ?, " +
                "description = ?, listImg = ? where listID = ?";
        try {
            pstmt = conn.prepareStatement(updatePlaylistSQL);
            pstmt.setString(1, playlist.getPlaylistName());
            pstmt.setString(2, playlist.getPlaylistDescription());
            pstmt.setString(3, playlist.getPlaylistImg());
            pstmt.setInt(4, playlist.getPlaylistID());
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
        String findAllPlaylistSQL = "select * from list";
        ResultSet rs = null;
        List<Playlist> playlists = null;
        try {
            pstmt = conn.prepareStatement(findAllPlaylistSQL);
            rs = pstmt.executeQuery();
            playlists = new ArrayList<>();
            while (rs.next()) {
                playlists.add(new Playlist(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getDate(4),
                        rs.getString(5), rs.getString(6), rs.getInt(7)));
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
        String findPlaylistByIDSQL = "select * from list where listID = ?";
        ResultSet rs =null;
        try {
            pstmt = conn.prepareStatement(findPlaylistByIDSQL);
            pstmt.setInt(1, playlistID);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Playlist(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getDate(4),
                        rs.getString(5), rs.getString(6), rs.getInt(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, pstmt, conn);
        }
        return null;
    }
}
