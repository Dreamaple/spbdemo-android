package com.dreamaple.baseutils;

import android.content.Context;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;

public class ViewFactory {

    TextView textView;

    public static int VIEW_NAME=1;

    public static void draw(Context context, JSONObject jsonObject) {

    }
    public TextView getTextView(Context context,JSONObject jsonObject) {
        textView = new TextView(context);
        jsonObject.containsKey(VIEW_NAME);
        return textView;
    }

}
