package com.imusic.daoImpl;

import com.imusic.bean.Playlist;
import com.imusic.dao.PlaylistTagDAO;
import com.imusic.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pan on 17-7-25.
 */
public class PlaylistTagDAOImpl implements PlaylistTagDAO {
    @Override
    public void addPlaylistTag(int playlistID, String tag) {

    }

    @Override
    public List<Playlist> findAllPlaylist(String tag) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String findAllSQL = "select * from list where listID in " +
                "(select listID from list_tag where tag = ?)";
        ResultSet rs = null;
        List<Playlist> playlists;
        try {
            pstmt = conn.prepareStatement(findAllSQL);
            pstmt.setString(1, tag);
            rs = pstmt.executeQuery();
            playlists = new ArrayList<>();
            while (rs.next()) {
                playlists.add(new Playlist(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getDate(4),
                        rs.getString(5), rs.getString(6), rs.getInt(7)));
            }
            return playlists;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, pstmt, conn);
        }
        return null;
    }
}
