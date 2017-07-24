package com.imusic.bean;

import java.util.Date;

/**
 * Created by pan on 17-7-21.
 */
public class PlaylistComment {

    /**
     * 歌单评论的数据信息
     */
    private int pCommentID;             // 歌单评论ID
    private String pCommentContent;     // 歌单评论内容
    private Date pCommentDate;          // 歌单评论日期
    private int userID;                 // 歌单评论者
    private int playlistID;             // 被评论的歌单ID
    private int pCommentAgreeNumber;    // 赞的个数

    public PlaylistComment(int pCommentID, String pCommentContent, Date pCommentDate,
                           int userID, int playlistID, int pCommentAgreeNumber) {
        this.pCommentID = pCommentID;
        this.pCommentContent = pCommentContent;
        this.pCommentDate = pCommentDate;
        this.userID = userID;
        this.playlistID = playlistID;
        this.pCommentAgreeNumber = pCommentAgreeNumber;
    }

    public int getpCommentID() {
        return pCommentID;
    }

    public void setpCommentID(int pCommentID) {
        this.pCommentID = pCommentID;
    }

    public String getpCommentContent() {
        return pCommentContent;
    }

    public void setpCommentContent(String pCommentContent) {
        this.pCommentContent = pCommentContent;
    }

    public Date getpCommentDate() {
        return pCommentDate;
    }

    public void setpCommentDate(Date pCommentDate) {
        this.pCommentDate = pCommentDate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPlaylistID() {
        return playlistID;
    }

    public void setPlaylistID(int playlistID) {
        this.playlistID = playlistID;
    }

    public int getpCommentAgreeNumber() {
        return pCommentAgreeNumber;
    }

    public void setpCommentAgreeNumber(int pCommentAgreeNumber) {
        this.pCommentAgreeNumber = pCommentAgreeNumber;
    }
}
