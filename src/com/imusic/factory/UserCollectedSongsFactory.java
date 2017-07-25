package com.imusic.factory;

import com.imusic.dao.UserCollectedSongsDAO;
import com.imusic.daoImpl.UserCollectedSongsDAOImpl;

/**
 * Created by pan on 17-7-25.
 */
public class UserCollectedSongsFactory {
    public static UserCollectedSongsDAO getUCSInstance() {
        return new UserCollectedSongsDAOImpl();
    }
}
