package com.dreamaple.user;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.fastjson.JSONObject;
import com.dreamaple.baseutils.BaseActivity;
import com.dreamaple.baseutils.LogUtil;
import com.dreamaple.baseutils.SpdUtils;
import com.dreamaple.baseutils.basevm.BaseViewModelFactory;
import com.dreamaple.baseutils.network.CallBack;
import com.dreamaple.baseutils.network.NetworkUtil;
import com.dreamaple.user.data.model.PhoneNumModel;
import com.dreamaple.user.data.viewmodel.PhoneNumViewModel;

@Route(path = "/user/main")
public class UserMainActivity extends BaseActivity {
    TextView textviewTest;
    PhoneNumViewModel phoneNumViewModel;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
        button = this.findViewById(R.id.get_net_btn);
        textviewTest = this.findViewById(R.id.textview_test);

        phoneNumViewModel = ViewModelProviders.of(this).get(PhoneNumViewModel.class);
        phoneNumViewModel.getPhoneNumModel().observe(this, new Observer<PhoneNumModel>() {
            @Override
            public void onChanged(PhoneNumModel phoneNumModel) {
                textviewTest.setText(phoneNumModel.getJsonObject().toJSONString());
//                Log.e(TAG, "onChanged: 数据有更新");
            } //注册观察者,观察数据的变化
        });

//        mBtnAddData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.e(TAG, "onClick: 已经点击");
//                mDemoViewModel.getDemoData().setTag1(123); //这里手动用按键点击更新数据
//
//            }
//        });

//        String username = "dalaoshu";
//        String nickname = "dalaoshua";
//        String pwd = "123123";
//        String sex = "1";
//        String tel = "13331545457";
//        String birth = "2014-01-20";
//        String email = "1212121@qq.com";
//        String signature = "anything";
//        String local = "dalaoshua";
//        NetworkUtil.getIns().create(UserApi.class).register(username,nickname,pwd,sex,tel,birth,email,signature,local).enqueue(new CallBack(new CallBack.ACallBack() {
//            @Override
//            public void successed(JSONObject jsonObject) {
//                phoneNumViewModel.getPhoneNumModel().setJsonObject(jsonObject);
//            }
//        }));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetworkUtil.getInsBilibili().create(UserApi.class).recommend().enqueue(new CallBack(new CallBack.ACallBack() {
                    @Override
                    public void successed(JSONObject jsonObject) {
                        phoneNumViewModel.getPhoneNumModel().setJsonObject(jsonObject);
                    }
                }));

            }
        });

    }
}
