package com.imusic.bean;

import java.util.Date;

/**
 * Created by pan on 17-7-21.
 */
public class SongComment {

    /**
     * 歌曲的评论数据信息
     */
    private int sCommentID;             // 歌曲评论ID
    private String sCommentContent;     // 歌曲评论内容
    private Date sCommentDate;          // 歌曲评论日期
    private int userID;                 // 歌曲评论者
    private int songID;             // 被评论的歌曲ID

    public int getsCommentID() {
        return sCommentID;
    }

    public void setsCommentID(int sCommentID) {
        this.sCommentID = sCommentID;
    }

    public String getsCommentContent() {
        return sCommentContent;
    }

    public void setsCommentContent(String sCommentContent) {
        this.sCommentContent = sCommentContent;
    }

    public Date getsCommentDate() {
        return sCommentDate;
    }

    public void setsCommentDate(Date sCommentDate) {
        this.sCommentDate = sCommentDate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getSongID() {
        return songID;
    }

    public void setSongID(int songID) {
        this.songID = songID;
    }
}
