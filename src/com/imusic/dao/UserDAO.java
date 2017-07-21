package com.imusic.dao;

import com.imusic.bean.User;

import java.util.List;

/**
 * Created by pan on 17-7-21.
 *
 * 声明用户相关操作
 */
public interface UserDAO {

    public void addUser(User user);         // 注册成功后就会添加用户
    public void updateUser(User user);      // 更新用户信息
    public void deleteUser(User user);      // 删除用户，比如用户选择注销账号
    public List<User> findAllUser();        // 查询所有用户
    public User findUserByID(int userID);   // 根据用户ID查找

}
