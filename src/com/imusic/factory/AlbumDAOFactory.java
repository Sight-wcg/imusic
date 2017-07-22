package com.imusic.factory;

import com.imusic.dao.AlbumDAO;
import com.imusic.daoImpl.AlbumDAOImpl;

/**
 * Created by pan on 17-7-22.
 */
public class AlbumDAOFactory {
    public static AlbumDAO getAlbumDAOInstance() {
        return new AlbumDAOImpl();
    }
}
