package com.imusic.dao;

import com.imusic.bean.Song;

import java.util.List;

/**
 * Created by pan on 17-7-24.
 */
public interface UserCollectedSongsDAO {

    // 添加收藏歌曲
    public void addCollectedSong(int userID, int songID);

    // 删除收藏歌曲
    public void delCollectedSong(int userID, int songID);

    // 查找（显示）收藏歌曲
    public List<Song> findAllSong(int userID);
}
