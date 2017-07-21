package com.imusic.bean;

import java.util.Date;

/**
 * Created by pan on 17-7-21.
 */
public class User {

    /**
     * 用户的数据
     */
    private int userID;                 // 用户ID
    private String userName;            // 用户名
    private String userPassword;        // 用户密码
    private String userEmail;           // 用户邮箱
    private int userGender;             // 1:男, 2:女, 3:保密
    private Date userRegisterDate;      // 用户注册时间
    private Date userBirthday;          // 用户的生日
    private String userAddress;         // 用户的住址
    private String userHeadHortrait;    // 用户头像
    private String userDescription;     // 用户个人介绍描述
    private Date userLastLoginDate;     // 用户上次登录时间

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getUserGender() {
        return userGender;
    }

    public void setUserGender(int userGender) {
        this.userGender = userGender;
    }

    public Date getUserRegisterDate() {
        return userRegisterDate;
    }

    public void setUserRegisterDate(Date userRegisterDate) {
        this.userRegisterDate = userRegisterDate;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserHeadHortrait() {
        return userHeadHortrait;
    }

    public void setUserHeadHortrait(String userHeadHortrait) {
        this.userHeadHortrait = userHeadHortrait;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public Date getUserLastLoginDate() {
        return userLastLoginDate;
    }

    public void setUserLastLoginDate(Date userLastLoginDate) {
        this.userLastLoginDate = userLastLoginDate;
    }
}
