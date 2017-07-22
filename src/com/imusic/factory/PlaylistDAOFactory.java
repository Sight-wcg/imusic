package com.imusic.factory;

import com.imusic.dao.PlaylistDAO;
import com.imusic.daoImpl.PlaylistDAOImpl;

/**
 * Created by pan on 17-7-22.
 */
public class PlaylistDAOFactory {
    public static PlaylistDAO getPlaylistDAOInstance() {
        return new PlaylistDAOImpl();
    }
}
