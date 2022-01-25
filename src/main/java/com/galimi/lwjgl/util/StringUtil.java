package com.galimi.lwjgl.util;

public class StringUtil {
    public static String join(Object... args) {
        StringBuffer sb = new StringBuffer(1024);
        for (Object s: args) {
            sb.append(s);
        }
        return sb.toString();
    }
}
