package com.example.spd_video.adapter;

import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.alibaba.fastjson.JSONObject;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dreamaple.baseutils.GlideUtil;
import com.dreamaple.baseutils.StringUtils;
import com.example.spd_video.R;
import com.example.spd_video.model.VideoDetailBean;

import java.util.List;

//public class VideoFragmentRecyclerViewAdapter extends BaseQuickAdapter<VideoDetailBean, BaseViewHolder> {
public class VideoFragmentRecyclerViewAdapter extends BaseQuickAdapter<JSONObject, BaseViewHolder> {
    /**
     * 动态，文章
     */
    private final static String ARTICLE = "A";
    /**
     * 推荐
     */
    private final static String RECOMMEND = "R";
    /**
     * 一般的视频
     */
    private final static String VIDEO = "V";

//    public VideoFragmentRecyclerViewAdapter(@Nullable List<VideoDetailBean> data) {
    public VideoFragmentRecyclerViewAdapter(@Nullable List<JSONObject> data) {
        super(R.layout.item_video_single, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, JSONObject item) {
//    protected void convert(BaseViewHolder helper, VideoDetailBean item) {
        helper.setVisible(R.id.tv_video_category, true)
                .setVisible(R.id.tv_video_recommend, true)
                .setVisible(R.id.tv_video_author, true)
                .setText(R.id.tv_video_category, StringUtils.removeNull(item.getString("typename")))
                .setText(R.id.tv_video_recommend, StringUtils.removeNull(item.getString("duration")))
                .setText(R.id.tv_video_title, StringUtils.removeNull(item.getString("title")))
                .setText(R.id.tv_video_author,StringUtils.removeNull(item.getString("author")));
        GlideUtil.setImg(mContext,item.getString("pic"), (ImageView) helper.getView(R.id.iv_video_cover));



//        helper.setVisible(R.id.tv_video_category, item.getType().contains(ARTICLE))
//                .setVisible(R.id.tv_video_recommend, item.getType().contains(RECOMMEND))
//                .setVisible(R.id.tv_video_author, item.getType().contains(VIDEO))
//                .setText(R.id.tv_video_category, StringUtils.removeNull(item.getCategory()))
//                .setText(R.id.tv_video_recommend, StringUtils.removeNull(item.getRecommend()))
//                .setText(R.id.tv_video_title, StringUtils.removeNull(item.getTitle()))
//                .setText(R.id.tv_video_author,StringUtils.removeNull(item.getAuthor()));
    }
}
