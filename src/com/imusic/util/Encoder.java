package com.imusic.util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by pan on 17-7-26.
 *
 * 用于提高数据的安全性
 */
public class Encoder {
    /**
     * 使用 MD5 来加密字符串
     * @param str
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    public static String EncoderByMD5(String str)
            throws UnsupportedEncodingException, NoSuchAlgorithmException {
        // 确定计算消息摘要的算法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64En = new BASE64Encoder();
        String EnStr = base64En.encode(md5.digest(str.getBytes("utf-8")));
        return EnStr;
    }

    /**
     * 判断用户输入的字符串加密后与从数据库中取出的是否相等
     * @param strPost：用户输入的字符串
     * @param strGet：从数据库中获取的已经加密过的字符串
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    public static boolean checkIsEqual(String strPost, String strGet)
            throws UnsupportedEncodingException, NoSuchAlgorithmException {
        if (EncoderByMD5(strPost).equals(strGet))
            return true;
        else
            return false;
    }
}
