package com.imusic.bean;

import java.util.Date;

/**
 * Created by pan on 17-7-21.
 */
public class PlaylistCommentReply {

    /**
     * 歌单评论的回复信息的数据
     */
    private int pCReplyID;          // 歌单评论回复ID
    private String pCReplyContent;  // 回复的内容
    private Date pCReplyDate;       // 回复的日期时间
    private int userID;             // 回复者ID
    private int pCommentID;         // 被回复的评论ID
    private int pCReplyAgreeNumber; // 赞的个数

    public PlaylistCommentReply(int pCommentID, String pCReplyContent, Date pCReplyDate,
                                int userID, int pCReplyID, int pCReplyAgreeNumber) {
        this.pCReplyID = pCReplyID;
        this.pCReplyContent = pCReplyContent;
        this.pCReplyDate = pCReplyDate;
        this.userID = userID;
        this.pCommentID = pCommentID;
        this.pCReplyAgreeNumber = pCReplyAgreeNumber;
    }

    public int getpCReplyID() {
        return pCReplyID;
    }

    public void setpCReplyID(int pCReplyID) {
        this.pCReplyID = pCReplyID;
    }

    public String getpCReplyContent() {
        return pCReplyContent;
    }

    public void setpCReplyContent(String pCReplyContent) {
        this.pCReplyContent = pCReplyContent;
    }

    public Date getpCReplyDate() {
        return pCReplyDate;
    }

    public void setpCReplyDate(Date pCReplyDate) {
        this.pCReplyDate = pCReplyDate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getpCommentID() {
        return pCommentID;
    }

    public void setpCommentID(int pCommentID) {
        this.pCommentID = pCommentID;
    }

    public int getpCReplyAgreeNumber() {
        return pCReplyAgreeNumber;
    }

    public void setpCReplyAgreeNumber(int pCReplyAgreeNumber) {
        this.pCReplyAgreeNumber = pCReplyAgreeNumber;
    }
}
