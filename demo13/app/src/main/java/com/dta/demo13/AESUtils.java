package com.dta.demo13;

import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESUtils {
    public static String decrypt(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(2, new SecretKeySpec(str2.getBytes("utf-8"), "AES"));
            return new String(instance.doFinal(Base64.decode(str, 0)), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static byte[] encrypt(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            Cipher instance = Cipher.getInstance("AES/ECB/PKCS5Padding");
            instance.init(1, new SecretKeySpec(str2.getBytes("utf-8"), "AES"));
            return Base64.encode(instance.doFinal(str.getBytes("utf-8")), 0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
