package com.example.spd_video.activity;

import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ListView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dreamaple.baseutils.BaseActivity;
import com.example.spd_video.R;
import com.example.spd_video.adapter.SimpleListVideoModeAdapter;
import com.shuyu.gsyvideoplayer.GSYVideoManager;

@Route(path = "/video/videoplayerlist")
public class VideoPlayerListActivity extends BaseActivity {


    ListView videoList;

    SimpleListVideoModeAdapter listNormalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player_list);

        videoList = (ListView)findViewById(R.id.video_list);

        listNormalAdapter = new SimpleListVideoModeAdapter(this);
        videoList.setAdapter(listNormalAdapter);

        videoList.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                int lastVisibleItem = firstVisibleItem + visibleItemCount;
                //大于0说明有播放
                if (GSYVideoManager.instance().getPlayPosition() >= 0) {
                    //当前播放的位置
                    int position = GSYVideoManager.instance().getPlayPosition();
                    //对应的播放列表TAG
                    if (GSYVideoManager.instance().getPlayTag().equals(SimpleListVideoModeAdapter.TAG)
                            && (position < firstVisibleItem || position > lastVisibleItem)) {
                        if(GSYVideoManager.isFullState(VideoPlayerListActivity.this)) {
                            return;
                        }
                        //如果滑出去了上面和下面就是否，和今日头条一样
                        GSYVideoManager.releaseAllVideos();
                        listNormalAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (GSYVideoManager.backFromWindowFull(this)) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        GSYVideoManager.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        GSYVideoManager.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GSYVideoManager.releaseAllVideos();
    }
}
