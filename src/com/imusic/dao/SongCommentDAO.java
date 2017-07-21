package com.imusic.dao;

import com.imusic.bean.SongComment;

import java.util.List;

/**
 * Created by pan on 17-7-21.
 * 
 * 歌曲评论操作接口
 */
public interface SongCommentDAO {

    public void addSongComment(SongComment sComment);          // 添加歌曲评论
    public void deleteSongComment(SongComment sComment);       // 删除歌曲评论
    public void updateSongComment(SongComment sComment);       // 更新歌曲评论
    public List<SongComment> findAllSongComment();             // 查找所有的歌曲评论
    public SongComment findSongCommentByID(int sCommentID);    // 根据sCommentID查找歌曲评论

}
