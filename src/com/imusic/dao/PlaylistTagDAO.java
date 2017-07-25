package com.imusic.dao;

import com.imusic.bean.Playlist;

import java.util.List;

/**
 * Created by pan on 17-7-25.
 */
public interface PlaylistTagDAO {

    // 添加歌单标签
    public void addPlaylistTag(int playlistID, String tag);

    // 根据标签查找歌单
    public List<Playlist> findAllPlaylist(String tag);
}
