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
    private String userHeadPortrait;    // 用户头像
    private String userDescription;     // 用户个人介绍描述
    private Date userLastLoginDate;     // 用户上次登录时间
    private String userPhoneNumber;     // 用户的电话号码
    private int userLevel;              // 用户的等级（活跃度）

    // 添加无参构造函数，为了注册时传递必须的几个属性
    public User(){}

    // 在查找用户业务中发现需要有参构造方法才能实现
    public User(int userID, String userName, String userPassword, String userEmail, String userPhoneNumber,
                int userGender, int userLevel, Date userRegisterDate, Date userBirthday, String userAddress,
                String userHeadPortrait, String userDescription, Date userLastLoginDate) {
        this.userID = userID;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userGender = userGender;
        this.userRegisterDate = userRegisterDate;
        this.userBirthday = userBirthday;
        this.userAddress = userAddress;
        this.userHeadPortrait = userHeadPortrait;
        this.userDescription = userDescription;
        this.userLastLoginDate = userLastLoginDate;
        this.userPhoneNumber = userPhoneNumber;
        this.userLevel = userLevel;
    }

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

    public String getUserHeadPortrait() {
        return userHeadPortrait;
    }

    public void setUserHeadPortrait(String userHeadPortrait) {
        this.userHeadPortrait = userHeadPortrait;
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

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }
}
