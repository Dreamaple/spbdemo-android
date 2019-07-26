package com.dreamaple.user;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.fastjson.JSONObject;
import com.dreamaple.baseutils.BaseActivity;
import com.dreamaple.baseutils.network.CallBack;
import com.dreamaple.baseutils.network.NetworkUtil;

@Route(path = "/user/main")
public class UserMainActivity extends BaseActivity {
    TextView textview_test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
        String username = "dalaoshu";
        String nickname = "dalaoshua";
        String pwd = "123123";
        String sex = "1";
        String tel = "13331545457";
        String birth = "2014-01-20";
        String email = "1212121@qq.com";
        String signature = "anything";
        String local = "dalaoshua";
        textview_test = this.findViewById(R.id.textview_test);
        NetworkUtil.getIns().create(UserApi.class).register(username,nickname,pwd,sex,tel,birth,email,signature,local).enqueue(new CallBack(new CallBack.ACallBack() {
            @Override
            public void successed(JSONObject jsonObject) {
                textview_test.setText(jsonObject.toJSONString());
            }
        }));
    }
}
