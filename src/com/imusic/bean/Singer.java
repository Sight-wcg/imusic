package com.imusic.bean;

/**
 * Created by pan on 17-7-21.
 */
public class Singer {

    /**
     * 歌手相关数据信息
     */
    private int singerID;
    private String singerName;
    private int singerGender;           // 1:男, 2:女   //可通过case判断设置信息
    private String singerNationality;   // 歌手的国籍
    private int singerHot;              // 歌手的热度（关注数）
    private String singerDescription;   // 歌手的描述
    private int singerAge;              // 歌手的年龄

    public Singer(int singerID, String singerName,
                  int singerGender, String singerNationality, int singerHot, String singerDescription, int singerAge) {
        this.singerID = singerID;
        this.singerName = singerName;
        this.singerGender = singerGender;
        this.singerNationality = singerNationality;
        this.singerHot = singerHot;
        this.singerDescription = singerDescription;
        this.singerAge = singerAge;
    }

    public int getSingerID() {
        return singerID;
    }

    public void setSingerID(int singerID) {
        this.singerID = singerID;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getSingerGender() {
        return singerGender;
    }

    public void setSingerGender(int singerGender) {
        this.singerGender = singerGender;
    }

    public String getSingerNationality() {
        return singerNationality;
    }

    public void setSingerNationality(String singerNationality) {
        this.singerNationality = singerNationality;
    }

    public int getSingerHot() {
        return singerHot;
    }

    public void setSingerHot(int singerHotkey) {
        this.singerHot = singerHot;
    }

    public String getSingerDescription() {
        return singerDescription;
    }

    public void setSingerDescription(String singerDescription) {
        this.singerDescription = singerDescription;
    }

    public int getSingerAge() {
        return singerAge;
    }

    public void setSingerAge(int singerAge) {
        this.singerAge = singerAge;
    }
}
