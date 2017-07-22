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
    private String playlistName;        // 歌单名称
    private String playlistDescription; // 歌单的描述
    private String playlistImg;         // 歌单封面的图片路径
    private Date playlistCreateDate;    // 歌单的创建日期

    public Playlist(int playlistID, int userID, String playlistName,
                    String playlistDescription, String playlistImg, Date playlistCreateDate) {
        this.playlistID = playlistID;
        this.userID = userID;
        this.playlistName = playlistName;
        this.playlistDescription = playlistDescription;
        this.playlistImg = playlistImg;
        this.playlistCreateDate = playlistCreateDate;
    }

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

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getPlaylistDescription() {
        return playlistDescription;
    }

    public void setPlaylistDescription(String playlistDescripton) {
        this.playlistDescription = playlistDescription;
    }

    public String getPlaylistImg() {
        return playlistImg;
    }

    public void setPlaylistImg(String playlistImg) {
        this.playlistImg = playlistImg;
    }

    public Date getPlaylistCreateDate() {
        return playlistCreateDate;
    }

    public void setPlaylistCreateDate(Date playlistCreateDate) {
        this.playlistCreateDate = playlistCreateDate;
    }
}
