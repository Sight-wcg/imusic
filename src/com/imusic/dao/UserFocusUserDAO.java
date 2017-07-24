package com.imusic.dao;

import com.imusic.bean.User;

import java.util.List;

/**
 * Created by pan on 17-7-24.
 */
public interface UserFocusUserDAO {

    // fromUserID 添加关注 toUserID
    public void addFocus(int fromUserID, int toUserID);

    // fromUserID 删除关注 toUserID
    public void delFocus(int fromUserID, int toUserID);

    // 查找 fromUserID 的所有关注（用于显示）
    public List<User> findAllUser(int fromUserID);
}
