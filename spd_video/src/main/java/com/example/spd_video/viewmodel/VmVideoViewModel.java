package com.example.spd_video.viewmodel;

import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSONObject;
import com.example.spd_video.adapter.VideoFragmentRecyclerViewAdapter;
import com.example.spd_video.model.VideoDetailBean;

import java.util.ArrayList;
import java.util.List;

public class VmVideoViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private RecyclerView recyclerView;
    private VideoFragmentRecyclerViewAdapter videoFragmentRecyclerViewAdapter;
    private List<VideoDetailBean> videoDetailBeans = new ArrayList<>();
    List<JSONObject> jsonObjects = new ArrayList<>();
//    "system.out.print(\"\u202E(\""
}
