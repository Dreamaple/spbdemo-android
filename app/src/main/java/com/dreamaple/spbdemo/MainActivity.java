package com.dreamaple.spbdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.alibaba.fastjson.JSONObject;
import com.bumptech.glide.util.Util;
import com.dreamaple.baseutils.BaseActivity;
import com.dreamaple.baseutils.network.CallBack;
import com.dreamaple.baseutils.network.NetworkUtil;

@Route(path = "/app/index")
public class MainActivity extends BaseActivity {
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btn);
        textView = findViewById(R.id.textView);
        button.setOnClickListener(v -> ARouter.getInstance().build("/user/main").navigation());
        NetworkUtil.getIns().create(MainApi.class).index().enqueue(new CallBack(new CallBack.ACallBack() {
            @Override
            public void successed(JSONObject jsonObject) {
                textView.setText(jsonObject.toJSONString());
            }
        }));
    }
}
