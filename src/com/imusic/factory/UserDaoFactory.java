package com.imusic.factory;

import com.imusic.dao.UserDao;
import com.imusic.daoImpl.UserDaoImpl;

/**
 * Created by pan on 17-7-21.
 */
public class UserDaoFactory {
    public static UserDao getUserDaoInstance() {
        return new UserDaoImpl();
    }
}
