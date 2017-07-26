package com.imusic.util;

import com.imusic.factory.UserDAOFactory;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by pan on 17-7-26.
 *
 * 用于认证用户的登录
 */
public class Authentication {
    /**
     * 可用于检查用户是否已注册
     * @param username
     * @return
     */
    public static boolean checkUserName(String username) {
        return UserDAOFactory.getUserDaoInstance().findUserByName(username) != null;
    }

    /**
     * 检查密码是否正确
     * @param pwPost
     * @param pwGet
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    public static boolean checkPassword(String pwPost, String pwGet)
            throws UnsupportedEncodingException, NoSuchAlgorithmException {
        return Encoder.checkIsEqual(pwPost, pwGet);
    }

    /**
     * 认证用户的登录
     * @param username
     * @param password
     * @return
     */
    public static boolean authentic(String username, String password)
            throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if (checkUserName(username)) {
            if (checkPassword(password, UserDAOFactory.getUserDaoInstance().findUserByName(username).getUserPassword())) {
                return true;
            }
        }
        return false;
    }
}
