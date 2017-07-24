package com.imusic.bean;

import java.util.Date;

/**
 * Created by pan on 17-7-21.
 */
public class SongCommentReply {

    /**
     * 歌曲评论的回复数据信息
     */
    private int sCReplyID;          // 歌曲评论回复ID
    private String sCReplyContent;  // 回复的内容
    private Date sCReplyDate;       // 回复的日期时间
    private int userID;             // 回复者ID
    private int sCommentID;         // 被回复的评论ID

    public SongCommentReply(int sCReplyID, String sCReplyContent,
                            Date sCReplyDate, int userID, int sCommentID) {
        this.sCReplyID = sCReplyID;
        this.sCReplyContent = sCReplyContent;
        this.sCReplyDate = sCReplyDate;
        this.userID = userID;
        this.sCommentID = sCommentID;
    }

    public int getsCReplyID() {
        return sCReplyID;
    }

    public void setsCReplyID(int sCReplyID) {
        this.sCReplyID = sCReplyID;
    }

    public String getsCReplyContent() {
        return sCReplyContent;
    }

    public void setsCReplyContent(String sCReplyContent) {
        this.sCReplyContent = sCReplyContent;
    }

    public Date getsCReplyDate() {
        return sCReplyDate;
    }

    public void setsCReplyDate(Date sCReplyDate) {
        this.sCReplyDate = sCReplyDate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getsCommentID() {
        return sCommentID;
    }

    public void setsCommentID(int sCommentID) {
        this.sCommentID = sCommentID;
    }
}
