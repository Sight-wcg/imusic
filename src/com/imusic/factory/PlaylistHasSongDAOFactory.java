package com.imusic.factory;

import com.imusic.dao.PlaylistHasSongDAO;
import com.imusic.daoImpl.PlaylistHasSongDAOImpl;

/**
 * Created by pan on 17-7-24.
 */
public class PlaylistHasSongDAOFactory {
    public static PlaylistHasSongDAO getPHSInstance() {
        return new PlaylistHasSongDAOImpl();
    }
}
