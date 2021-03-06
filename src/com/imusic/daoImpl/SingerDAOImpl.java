package com.imusic.daoImpl;

import com.imusic.bean.Singer;
import com.imusic.dao.SingerDAO;
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
 * 道理同SongDAO
 */
public class SingerDAOImpl implements SingerDAO {
    @Override
    public void addSinger(Singer singer) {

    }

    @Override
    public void deleteSinger(Singer singer) {
        int id = singer.getSingerID();
        String delSingerSQL = "delete from singer where singerID = ?";
        DBOperation.deleteItem(id, delSingerSQL);
    }

    @Override
    public void updateSinger(Singer singer) {

    }

    @Override
    public List<Singer> findAllSinger() {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String findAllSongSQL = "select * from singer";
        ResultSet rs = null;
        List<Singer> singerList;
        try {
            pstmt = conn.prepareStatement(findAllSongSQL);
            rs = pstmt.executeQuery();
            singerList = new ArrayList<>();
            while (rs.next()) {
                singerList.add(new Singer(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getString(4), rs.getInt(5),
                        rs.getString(6), rs.getString(7)));
            }
            return singerList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, pstmt, conn);
        }

        return null;
    }

    @Override
    public Singer findSingerByID(int singerID) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstmt = null;
        String findSingerByIDSQL = "select * from singer where singerID = ?";
        ResultSet rs =null;
        try {
            pstmt = conn.prepareStatement(findSingerByIDSQL);
            pstmt.setInt(1, singerID);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                new Singer(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getString(4), rs.getInt(5),
                        rs.getString(6), rs.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs, pstmt, conn);
        }
        return null;
    }
}
