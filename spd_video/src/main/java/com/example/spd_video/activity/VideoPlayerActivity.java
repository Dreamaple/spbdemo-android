package com.example.spd_video.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dreamaple.baseutils.BaseActivity;
import com.example.spd_video.R;
import com.example.spd_video.view.SampleCoverVideo;
import com.google.android.material.appbar.AppBarLayout;

@Route(path = "/video/videoplayer")
public class VideoPlayerActivity extends BaseActivity {
    SampleCoverVideo gsyVideoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
//        final String urlH = "http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4";
        final String url = "http://7xjmzj.com1.z0.glb.clouddn.com/20171026175005_JObCxCE2.mp4";
        gsyVideoPlayer = findViewById(R.id.detail_player);
//        if (position % 2 == 0) {
//            gsyVideoPlayer.loadCoverImage(url, R.drawable.glide_error);
//        } else {
        gsyVideoPlayer.loadCoverImage(url, R.drawable.basedemo);
//        }

        gsyVideoPlayer.setUpLazy(url, true, null, null, "这是title");
        //增加title
        gsyVideoPlayer.getTitleTextView().setVisibility(View.GONE);
        //设置返回键
        gsyVideoPlayer.getBackButton().setVisibility(View.GONE);
        //设置全屏按键功能
        gsyVideoPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gsyVideoPlayer.startWindowFullscreen(getBaseContext(), false, true);
            }
        });
        //防止错位设置
//        gsyVideoPlayer.setPlayTag(TAG);
//        gsyVideoPlayer.setPlayPosition(position);
        //是否根据视频尺寸，自动选择竖屏全屏或者横屏全屏
        gsyVideoPlayer.setAutoFullWithSize(true);
        //音频焦点冲突时是否释放
        gsyVideoPlayer.setReleaseWhenLossAudio(false);
        //全屏动画
        gsyVideoPlayer.setShowFullAnimation(true);
        //小屏时不触摸滑动
        gsyVideoPlayer.setIsTouchWiget(false);




//        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) mCollToolBarLayout.setLayoutParams(params);
////设置不能滑动
//        params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED);
//        mCollToolBarLayout.getLayoutParams();

//以下代码是让CollToolBarLayout获取焦点的，如果不设置，可能会有问题；
//mCollToolBarLayout.setFocusable(true);
//mCollToolBarLayout.setFocusableInTouchMode(true);
//mCollToolBarLayout.requestFocus();

//        AppBarLayout.LayoutParams params1 = (AppBarLayout.LayoutParams) mCollToolBarLayout.getLayoutParams();
//可以滑动，实现折叠悬浮效果
//        params.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL|AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED);
//        mCollToolBarLayout.getLayoutParams();
//————————————————
//        版权声明：本文为CSDN博主「微信号 lanjixingxun」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
//        原文链接：https://blog.csdn.net/LXFX1108/article/details/86711284
    }
    /**
     * {https://www.jianshu.com/p/7caa5f4f49bd}
     * flag的用法
     */
}
