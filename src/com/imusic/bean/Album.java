package com.imusic.bean;

import java.util.Date;

/**
 * Created by pan on 17-7-21.
 */
public class Album {

    /**
     * 歌手专辑的数据信息
     */
    private int albumID;            // 专辑ID
    private String albumName;       // 专辑名字
    private int singerID;           // 专辑所属歌手的ID
    private Date albumCreateDate;   // 专辑创建的日期(也可延伸为专辑的年份)
    private String albumImg;        // 专辑封面的图片路径
    private String albumDescription;// 专辑的描述

    public Album(int albumID, String albumName, int singerID,
                 Date albumCreateDate, String albumImg, String albumDescription) {
        this.albumID = albumID;
        this.albumName = albumName;
        this.singerID = singerID;
        this.albumCreateDate = albumCreateDate;
        this.albumImg = albumImg;
        this.albumDescription = albumDescription;
    }

    public int getAlbumID() {
        return albumID;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getSingerID() {
        return singerID;
    }

    public void setSingerID(int singerID) {
        this.singerID = singerID;
    }

    public Date getAlbumCreateDate() {
        return albumCreateDate;
    }

    public void setAlbumCreateDate(Date albumCreateDate) {
        this.albumCreateDate = albumCreateDate;
    }

    public String getAlbumImg() {
        return albumImg;
    }

    public void setAlbumImg(String albumImg) {
        this.albumImg = albumImg;
    }

    public String getAlbumDescription() {
        return albumDescription;
    }

    public void setAlbumDescription(String albumDescription) {
        this.albumDescription = albumDescription;
    }
}
