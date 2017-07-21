package com.imusic.dao;

import com.imusic.bean.Playlist;

import java.util.List;

/**
 * Created by pan on 17-7-21.
 * 
 * 声明歌单相关操作
 */
public interface PlaylistDAO {
    public void addPlaylist(Playlist Playlist);          // 添加歌单
    public void deletePlaylist(Playlist Playlist);       // 删除歌单
    public void updatePlaylist(Playlist Playlist);       // 更新歌单
    public List<Playlist> findAllPlaylist();          // 查找所有的歌单
    public Playlist findPlaylistByID(int PlaylistID);    // 根据PlaylistID查找歌单
    // 根据后续业务，可能需要 findPlaylistByName(String PlaylistName);
}
