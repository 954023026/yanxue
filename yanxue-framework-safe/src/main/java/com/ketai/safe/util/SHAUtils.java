package com.ketai.safe.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @description: SHAUtils 字节转码工具类
 * @author: xuhao
 * @time: 2019/12/6 10:17
 */
public class SHAUtils {
    public static String encodeData(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(str.getBytes());
            byte[] byteData = md.digest();
            /**
             *将字节转换为十六进制格式方法一
             */
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            System.out.println("Hex format : " + sb.toString());
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String s = SHAUtils.encodeData("pw888888");
        System.out.println(s);
    }
}
