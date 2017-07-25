package com.imusic.factory;

import com.imusic.dao.PlaylistTagDAO;
import com.imusic.daoImpl.PlaylistTagDAOImpl;

/**
 * Created by pan on 17-7-25.
 */
public class PlaylistTagDAOFactory {
    public static PlaylistTagDAO getPTInstance() {
        return new PlaylistTagDAOImpl();
    }
}
