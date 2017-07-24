package com.imusic.dao;

import com.imusic.bean.PlaylistCommentReply;

import java.util.List;

/**
 * Created by pan on 17-7-21.
 *
 * 声明歌单评论回复相关接口操作
 */
public interface PlaylistCommentReplyDAO {

    public void addPlaylistCommentReply(PlaylistCommentReply pCReply);              // 添加歌单评论的回复
    public void deletePlaylistCommentReply(PlaylistCommentReply pCReply);           // 删除歌单评论的回复
    public void updatePlaylistCommentReply(PlaylistCommentReply pCReply);           // 更新歌单评论的回复
    public List<PlaylistCommentReply> findAllPlaylistCommentReply(int pCommentID);  // 查找指定的歌单评论回复
    public PlaylistCommentReply findPlaylistCommentReplyByID(int pCReplyID);        // 根据pCReplyID查找歌单评论
}
