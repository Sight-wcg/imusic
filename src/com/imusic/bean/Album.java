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
}
