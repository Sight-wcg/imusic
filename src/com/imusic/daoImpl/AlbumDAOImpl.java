package com.imusic.daoImpl;

import com.imusic.bean.Album;
import com.imusic.dao.AlbumDAO;
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
public class AlbumDAOImpl implements AlbumDAO {

    @Override
    public void addAlbum(Album album) {

    }

    @Override
    public void deleteAlbum(Album album) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String delAlbumSQL = "delete from album where albumID = ?";
        try {
            pstmt = conn.prepareStatement(delAlbumSQL);
            pstmt.setInt(1, album.getAlbumID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(pstmt, conn);
        }
    }

    @Override
    public void updateAlbum(Album album) {

    }

    @Override
    public List<Album> findAllAlbum() {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String findAllAlbumSQL = "select * from album";
        ResultSet rs = null;
        List<Album> albumList = null;
        try {
            pstmt = conn.prepareStatement(findAllAlbumSQL);
            rs = pstmt.executeQuery();
             albumList = new ArrayList<>();
            while (rs.next()) {
                albumList.add(new Album(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getDate(4), rs.getString(5)));
            }
            return albumList;
        } catch(SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, pstmt, conn);
        }
        return null;
    }

    @Override
    public Album findAlbumByID(int albumID) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String findAlbumByIDSQL = "select * from album where albumID = ?";
        ResultSet rs =null;
        try {
            pstmt = conn.prepareStatement(findAlbumByIDSQL);
            pstmt.setInt(1, albumID);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Album(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getDate(4), rs.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, pstmt, conn);
        }
        return null;
    }
}
