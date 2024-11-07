package com.zxx17.couple.util;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;


/**
 * .
 *
 * @author Xinxuan Zhuo
 * @version 1.0.0
 * @since 2024/10/27
 **/
public class SaltMD5Utils {

    /**
     * MD5加密
     * @param str 要加密的字符串
     */
    public static String MD5(String str) {
        MessageDigest md5 = null;
        try {
            // 生成普通的MD5密码
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            return "check jdk";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        char[] charArray = str.toCharArray();
        byte[] byteArray = new byte[charArray.length];
        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }


    /**
     * 生成加盐后的MD5码
     */
    public static String generateSaltPassword(String password, String salt) {
        return md5Hex(password + salt);
    }

    /**
     * 验证明文和加盐后的MD5码是否匹配
     */
    public static boolean verifySaltPassword(String password, String salt, String md5) {
        return Objects.equals(md5Hex(password + salt), md5);
    }

    /**
     * 生成MD5密码
     */
    private static String md5Hex(String src) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new Hex().encode(bs));
        } catch (Exception e) {
            return null;
        }
    }


}



