package com.imusic.factory;

import com.imusic.dao.PlaylistCommentReplyDAO;
import com.imusic.daoImpl.PlaylistCommentReplyDAOImpl;

/**
 * Created by pan on 17-7-22.
 */
public class PlaylistCommentReplyDAOFactory {
    public static PlaylistCommentReplyDAO getPlaylistCommentReplyInstance() {
        return new PlaylistCommentReplyDAOImpl();
    }
}
