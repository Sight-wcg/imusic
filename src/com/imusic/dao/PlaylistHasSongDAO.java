package com.imusic.dao;

import com.imusic.bean.Song;

import java.util.List;

/**
 * Created by pan on 17-7-24.
 */

public interface PlaylistHasSongDAO {

    // 从歌单中添加歌曲
    public void addSongIntoPlaylist(int playlistID, int songID);

    // 从歌单中删除歌曲
    public void delSongFromPlaylist(int playlistID, int songID);

    // 从歌单中显示歌曲
    public List<Song> findAllSong(int playlistID);
}
