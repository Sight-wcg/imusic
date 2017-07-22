package com.imusic.factory;

import com.imusic.dao.PlaylistCommentDAO;
import com.imusic.daoImpl.PlaylistCommentDAOImpl;

/**
 * Created by pan on 17-7-22.
 */
public class PlaylistCommentDAOFactory {
    public static PlaylistCommentDAO getPlaylistCommentDAOInstance() {
        return new PlaylistCommentDAOImpl();
    }
}
