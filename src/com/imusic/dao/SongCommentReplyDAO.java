package com.imusic.dao;


import com.imusic.bean.SongCommentReply;

import java.util.List;

/**
 * Created by pan on 17-7-21.
 * 
 * 声明歌曲评论回复的相关接口操作
 */
public interface SongCommentReplyDAO {

    public void addSongCommentReply(SongCommentReply sCReply);          // 添加歌曲评论的回复
    public void deleteSongCommentReply(SongCommentReply sCReply);       // 删除歌曲评论的回复
    public void updateSongComment(SongCommentReply sCReply);            // 更新歌曲评论的回复
    public List<SongCommentReply> findAllSongCommentReply();            // 查找所有的歌曲评论的回复
    public SongCommentReply findSongCommentReplyByID(int sCReplyID);    // 根据sCReplyID查找歌曲评论的回复
}
