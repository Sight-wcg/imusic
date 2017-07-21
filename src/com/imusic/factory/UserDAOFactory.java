package com.imusic.factory;

import com.imusic.dao.UserDAO;
import com.imusic.daoImpl.UserDAOImpl;

/**
 * Created by pan on 17-7-21.
 */
public class UserDAOFactory {
    public static UserDAO getUserDaoInstance() {
        return new UserDAOImpl();
    }
}
