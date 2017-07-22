package com.imusic.factory;

import com.imusic.dao.SingerDAO;
import com.imusic.daoImpl.SingerDAOImpl;

/**
 * Created by pan on 17-7-22.
 */
public class SingerDAOFactory {
    public static SingerDAO getSingerDAOInstance() {
        return new SingerDAOImpl();
    }
}
