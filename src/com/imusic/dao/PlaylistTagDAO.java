package com.imusic.dao;

import com.imusic.bean.Playlist;

import java.util.List;

/**
 * Created by pan on 17-7-25.
 */
public interface PlaylistTagDAO {

    // ��Ӹ赥��ǩ
    public void addPlaylistTag(int playlistID, String tag);

    // ���ݱ�ǩ���Ҹ赥
    public List<Playlist> findAllPlaylist(String tag);
}
