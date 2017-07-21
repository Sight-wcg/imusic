package com.imusic.dao;

import com.imusic.bean.PlaylistComment;

import java.util.List;

/**
 * Created by pan on 17-7-21.
 * 
 * 声明歌单评论操作
 */
public interface PlaylistCommentDAO {
    /**
     * 根据实际场景，主要的是前面三个方法
     * @param PlaylistComment
     */
    public void addPlaylistComment(PlaylistComment PlaylistComment);          // 添加专辑
    public void deletePlaylistComment(PlaylistComment PlaylistComment);       // 删除专辑
    public void updatePlaylistComment(PlaylistComment PlaylistComment);       // 更新专辑
    public List<PlaylistComment> findAllPlaylistComment();                    // 查找所有的专辑
    public PlaylistComment findPlaylistCommentByID(int PlaylistCommentID);    // 根据PlaylistCommentID查找专辑
    // 根据后续业务，可能需要 findPlaylistCommentByName(String PlaylistCommentName);
}
