package com.imusic.factory;

import com.imusic.dao.SongCommentReplyDAO;
import com.imusic.daoImpl.SongCommentReplyDAOImpl;

/**
 * Created by pan on 17-7-22.
 */
public class SongCommentReplyDAOFactory {
    public static SongCommentReplyDAO getSongCommentReplyDAOInstance() {
        return new SongCommentReplyDAOImpl();
    }
}
