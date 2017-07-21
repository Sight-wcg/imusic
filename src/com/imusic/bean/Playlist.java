package com.imusic.bean;

import java.util.Date;

/**
 * Created by pan on 17-7-21.
 */
public class Playlist {

    /**
     * 歌单的数据信息(该歌单可由用户创建)
     */
    private int playlistID;             // 歌单的ID
    private int userID;                 // 歌单创建者ID
    private String playlistDescripton;  // 歌单的名称
    private Date playlistCreateDate;    // 歌单的创建日期

    public int getPlaylistID() {
        return playlistID;
    }

    public void setPlaylistID(int playlistID) {
        this.playlistID = playlistID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getPlaylistDescripton() {
        return playlistDescripton;
    }

    public void setPlaylistDescripton(String playlistDescripton) {
        this.playlistDescripton = playlistDescripton;
    }

    public Date getPlaylistCreateDate() {
        return playlistCreateDate;
    }

    public void setPlaylistCreateDate(Date playlistCreateDate) {
        this.playlistCreateDate = playlistCreateDate;
    }
}
