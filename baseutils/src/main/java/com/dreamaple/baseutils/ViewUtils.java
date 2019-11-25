package com.dreamaple.baseutils;

import android.view.ViewGroup;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public final class ViewUtils {

    public static String CLICK_METHOD = "cl_met";
    public static String CLICK_METHOD_URL = "cl_met_url";
    public static String CLICK_METHOD_PARAMETER = "cl_met_par";


    {
        JSONArray parameter = new JSONArray();
        JSONObject url = new JSONObject();
        JSONObject demo = new JSONObject();
        url.put(CLICK_METHOD_URL, "/url/url");
        parameter.add("param_name");
        url.put(CLICK_METHOD_PARAMETER, "url");
        demo.put(CLICK_METHOD, url);
        if (parameter.size() != 0||demo.size()!=0) {
            int i = 1;
        }
    }

    public ViewUtils(ViewGroup viewGroup) {

    }

    public boolean drawView(JSONObject jsonObject){
        return false;
    }

    public void isBundle(){

    }
}
