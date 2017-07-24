package com.imusic.dao;

import com.imusic.bean.Song;

import java.util.List;

/**
 * Created by pan on 17-7-21.
 * 
 * 声明歌曲操作信息
 */
public interface SongDAO {
    public void addSong(Song song, int playlistID);          // 添加歌曲
    public void deleteSong(Song song);       // 删除歌曲
    public void updateSong(Song song);       // 更新歌曲信息
    public List<Song> findAllSong();          // 查找所有的歌曲
    public Song findSongByID(int songID);    // 根据SongID查找歌曲
    // 根据后续业务(比如搜索业务),可能需要 findSongByName(String songName);
}
