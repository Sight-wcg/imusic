package com.imusic.daoImpl;

import com.imusic.bean.Song;
import com.imusic.dao.UserCollectedSongsDAO;

import java.util.List;

/**
 * Created by pan on 17-7-25.
 */
public class UserCollectedSongsDAOImpl implements UserCollectedSongsDAO {
    @Override
    public void addCollectedSong(int userID, int songID) {

    }

    @Override
    public void delCollectedSong(int userID, int songID) {

    }

    @Override
    public List<Song> findAllSong(int userID) {
        return null;
    }
}
