package com.fta.utils;

import sun.misc.BASE64Decoder;

import java.io.IOException;

/**
 * Created by Admin on 2018/7/24
 */
public class Base64Util {

    public static String base64decode(String encodeInfo) throws IOException {
        byte[] bytes = new BASE64Decoder().decodeBuffer(encodeInfo);
        return new String(bytes, "utf-8");
    }
}
