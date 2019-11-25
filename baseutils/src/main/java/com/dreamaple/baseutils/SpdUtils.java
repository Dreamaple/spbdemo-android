package com.dreamaple.baseutils;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Method;
import java.util.List;

public class SpdUtils {
    public static int getNavigationBarHeight(Context context) {
        int navigationBarHeight = 0;
        Resources rs = context.getResources();
        int id = rs.getIdentifier("navigation_bar_height", "dimen", "android");
        if (id > 0 && checkDeviceHasNavigationBar(context)) {
            navigationBarHeight = rs.getDimensionPixelSize(id);
        }
        return navigationBarHeight;
    }


    private static boolean checkDeviceHasNavigationBar(Context context) {

    boolean hasNavigationBar = false;
    Resources rs = context.getResources();
    int id = rs.getIdentifier("config_showNavigationBar", "bool", "android");
    if (id > 0) {
        hasNavigationBar = rs.getBoolean(id);
    }
    try {
        Class systemPropertiesClass = Class.forName("android.os.SystemProperties");
        Method m = systemPropertiesClass.getMethod("get", String.class);
        String navBarOverride = (String) m.invoke(systemPropertiesClass, "qemu.hw.mainkeys");
        if ("1".equals(navBarOverride)) {
            hasNavigationBar = false;
        } else if ("0".equals(navBarOverride)) {
            hasNavigationBar = true;
        }
    } catch (Exception e) {
        Log.w(LogUtil.TAG, e);
    }
    return hasNavigationBar;
}
    public static int getStatusBarHeight(Context context)
    {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0)
        {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }


//2.fastjson  JSONArray转List
    public static List<JSONObject> fastJsonArray2List(JSONArray array){
        List<JSONObject> list = JSONObject.parseArray(array.toJSONString(), JSONObject.class);
        return list;
    }
}
