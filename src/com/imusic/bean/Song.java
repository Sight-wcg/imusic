package com.imusic.bean;

/**
 * Created by pan on 17-7-21.
 */
public class Song {

    /**
     * 歌曲的数据
     */
    private int songID;         // 歌曲的ID
    private String songName;    // 歌曲的名字
    private int albumID;        // 所属专辑的ID   // 暂时保留不碍事
    private String songType;    // 歌曲的类型
    private String songURL;     // 歌曲的链接url
    private int songDownTimes;  // 歌曲被下载的次数
    private int songAccessTime; // 歌曲被访问(收听)的次数
    private String songImgURL;  // 歌曲的图片路径
    private String singerName;  // 歌曲的作者    // 为了跳过Album好录入数据

    public Song(int songID, String songName, int albumID, String songType,
                String songURL, int songDownTimes, int songAccessTime, String songImgURL, String singerName) {
        this.songID = songID;
        this.songName = songName;
        this.albumID = albumID;
        this.songType = songType;
        this.songURL = songURL;
        this.songDownTimes = songDownTimes;
        this.songAccessTime = songAccessTime;
        this.songImgURL = songImgURL;
        this.singerName = singerName;
    }

    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getAlbumID() {
        return albumID;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }

    public String getSongType() {
        return songType;
    }

    public void setSongType(String songType) {
        this.songType = songType;
    }

    public String getSongURL() {
        return songURL;
    }

    public void setSongURL(String songURL) {
        this.songURL = songURL;
    }

    public int getSongDownTimes() {
        return songDownTimes;
    }

    public void setSongDownTimes(int songDownTimes) {
        this.songDownTimes = songDownTimes;
    }

    public int getSongAccessTime() {
        return songAccessTime;
    }

    public void setSongAccessTime(int songAccessTime) {
        this.songAccessTime = songAccessTime;
    }

    public String getSongImgURL() {
        return songImgURL;
    }

    public void setSongImgURL(String songImgURL) {
        this.songImgURL = songImgURL;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }
}
