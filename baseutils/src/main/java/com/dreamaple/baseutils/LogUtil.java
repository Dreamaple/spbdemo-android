package com.dreamaple.baseutils;

import android.text.TextUtils;
import android.util.Log;

public class LogUtil {
    final static String TAG = "spbdemo";
    static final int TYPE_I = 1;
    static final int TYPE_E = 2;

    public static void i(String msg) {
        i("", msg);
    }

    public static void i(String tag, String msg) {
        setLog(TYPE_I, tag, msg);
    }

    public static void e(String msg) {
        e("", msg);
    }

    public static void e(String tag, String msg) {
        setLog(TYPE_E, tag, msg);
    }

    /**
     * @param lv  i-1 e-2
     * @param tag log的tag
     * @param msg log的msg
     */
    private static void setLog(int lv, String tag, String msg) {
        if (!BaseApplication.getInstance().isDebug()) {
            return;
        }
        switch (lv) {
            case TYPE_I:
                if (TextUtils.isEmpty(tag)) {
                    Log.i(TAG, msg);
                } else {
                    Log.i(TAG + "_" + tag, msg);
                }
                break;
            case TYPE_E:
                if (TextUtils.isEmpty(tag)) {
                    Log.e(TAG, msg);
                } else {
                    Log.e(TAG + "_" + tag, msg);
                }
                break;
                default:
        }
    }

}
