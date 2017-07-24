package com.imusic.factory;

import com.imusic.dao.UserFocusUserDAO;
import com.imusic.daoImpl.UserFocusUserDAOImpl;

/**
 * Created by pan on 17-7-24.
 */
public class UserFocusUserDAOFactory {
    public static UserFocusUserDAO getUFUInstance() {
        return new UserFocusUserDAOImpl();
    }
}
