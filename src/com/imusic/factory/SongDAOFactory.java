package com.imusic.factory;

import com.imusic.dao.SongDAO;
import com.imusic.daoImpl.SongDAOImpl;

/**
 * Created by pan on 17-7-22.
 */
public class SongDAOFactory {
    public static SongDAO getSongDAOInstance() {
        return new SongDAOImpl();
    }
}
