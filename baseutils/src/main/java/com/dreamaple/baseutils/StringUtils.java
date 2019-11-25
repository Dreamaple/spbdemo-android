package com.dreamaple.baseutils;

import android.text.TextUtils;

public class StringUtils {
    public static String removeNull(String s) {
        return TextUtils.isEmpty(s) ? "" : s;
    }

    public static boolean checkVisible(String string,String type) {
        return string.contains(type);
    }
}
