package com.imusic.dao;

import com.imusic.bean.PlaylistComment;

import java.util.List;

/**
 * Created by pan on 17-7-21.
 * 
 * 声明歌单评论操作
 */
public interface PlaylistCommentDAO {

    public void addPlaylistComment(PlaylistComment playlistComment);          // 添加歌单评论
    public void deletePlaylistComment(PlaylistComment playlistComment);       // 删除歌单评论
    public void updatePlaylistComment(PlaylistComment playlistComment);       // 更新歌单评论
    public List<PlaylistComment> findAllPlaylistComment();                    // 查找所有的歌单评论
    public PlaylistComment findPlaylistCommentByID(int pCommentID);           // 根据pCommentID查找歌单评论

}
