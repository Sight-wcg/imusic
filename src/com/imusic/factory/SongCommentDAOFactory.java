package com.imusic.factory;

import com.imusic.dao.SongCommentDAO;
import com.imusic.daoImpl.SongCommentDAOImpl;

/**
 * Created by pan on 17-7-22.
 */
public class SongCommentDAOFactory {
    public static SongCommentDAO getSongCommentDAOInstance() {
        return new SongCommentDAOImpl();
    }
}
