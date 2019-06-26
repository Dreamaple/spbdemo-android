package com.dreamaple.baseutils;

import android.app.Application;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;

public class BaseApplication extends Application {

    Toast toast;

    private boolean debug = true;

    public static BaseApplication baseApplication;

    public boolean isDebug() {
        return debug;
    }

    public static BaseApplication getInstance() {
        return baseApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        baseApplication = this;
        if (isDebug()) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(baseApplication); // 尽可能早，推荐在Application中初始化
    }

    public void spdToast(String msg) {
        if (toast != null) {
            toast.cancel();
        } else {
            toast = new Toast(this);
        }
        toast.setText(msg);
        toast.show();
//        Toast.makeText(this, msg, Toast.LENGTH_SHORT);
    }
}
