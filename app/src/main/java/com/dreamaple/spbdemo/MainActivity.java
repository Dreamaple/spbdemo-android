package com.dreamaple.spbdemo;

import android.os.Build;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dreamaple.baseutils.BaseActivity;
import com.dreamaple.baseutils.BaseFragment;
import com.dreamaple.baseutils.LogUtil;
import com.dreamaple.baseutils.view.SpdTabView;
import com.example.spd_video.fragment.VideoFragment;

import java.util.ArrayList;
import java.util.List;

@Route(path = "/app/index")
public class MainActivity extends BaseActivity {
//    Button button;
//    TextView textView;
    SpdTabView spdTabView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spdTabView = findViewById(R.id.mytab);
        VideoFragment videoFragment1 = new VideoFragment();
//        VideoFragment videoFragment2 = new VideoFragment();
//        VideoFragment videoFragment3 = new VideoFragment();
//        VideoFragment videoFragment4 = new VideoFragment();
        List<BaseFragment> baseFragments = new ArrayList<>();
        baseFragments.add(videoFragment1);
//        baseFragments.add(videoFragment2);
//        baseFragments.add(videoFragment3);
//        baseFragments.add(videoFragment4);
        List<String> title = new ArrayList<>();
        title.add("1");
//        title.add("2");
//        title.add("3");
//        title.add("4");
        spdTabView.setData(title,baseFragments);
//        String s = Build.USER;
        String s = Build.VERSION.INCREMENTAL;
        LogUtil.e(s);
//        spdTabView.setInstance(this);
//        button = findViewById(R.id.btn);
//        textView = findViewById(R.id.textView);
//        button.setOnClickListener(v -> ARouter.getInstance().build("/user/main").navigation());
//        button.setOnClickListener(v -> BaseApplication.getInstance().spdToast("aaaaa"));
//        NetworkUtil.getIns().create(MainApi.class).index().enqueue(new CallBack(new CallBack.ACallBack() {
//            @Override
//            public void successed(JSONObject jsonObject) {
//                textView.setText(jsonObject.toJSONString());
//            }
//        }));
//
//        Log.e("1111111111","android.os.Build.BRAND;" +android.os.Build.BRAND+
//                "\nandroid.os.Build.MODEL;" + android.os.Build.MODEL +
//                "\nandroid.os.Build.VERSION.CODENAME;" + android.os.Build.VERSION.CODENAME +
//                "\nandroid.os.Build.VERSION.RELEASE;" + android.os.Build.VERSION.RELEASE);

    }
}
