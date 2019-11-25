package com.example.spd_video.fragment;

import android.Manifest;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.fastjson.JSONObject;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dreamaple.baseutils.BaseFragment;
import com.dreamaple.baseutils.LogUtil;
import com.dreamaple.baseutils.SpdUtils;
import com.dreamaple.baseutils.network.CallBack;
import com.dreamaple.baseutils.network.NetworkUtil;
import com.example.spd_video.R;
import com.example.spd_video.VideoApi;
import com.example.spd_video.adapter.VideoFragmentRecyclerViewAdapter;
import com.example.spd_video.model.VideoDetailBean;

import org.jokar.permissiondispatcher.annotation.NeedsPermission;
import org.jokar.permissiondispatcher.annotation.OnNeverAskAgain;
import org.jokar.permissiondispatcher.annotation.OnPermissionDenied;
import org.jokar.permissiondispatcher.annotation.OnShowRationale;
import org.jokar.permissiondispatcher.annotation.RuntimePermissions;
import org.jokar.permissiondispatcher.library.PermissionRequest;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link VideoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link VideoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@RuntimePermissions
public class VideoFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private VideoFragmentRecyclerViewAdapter videoFragmentRecyclerViewAdapter;
    private List<VideoDetailBean> videoDetailBeans = new ArrayList<>();
    List<JSONObject> jsonObjects = new ArrayList<>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public VideoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VideoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VideoFragment newInstance(String param1, String param2) {
        VideoFragment fragment = new VideoFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_video, container, false);
//    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    protected int setLayoutResourceID() {
        return R.layout.fragment_video;
    }

    @Override
    protected void setUpView() {
        recyclerView = getContentView().findViewById(R.id.rv_video_list);
    }

    @NeedsPermission({Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE})
    public void dadad(){

    }
    @OnShowRationale({Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE})
    public void dadadWhy(PermissionRequest request){

    }

    @OnPermissionDenied({Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE})
    public void dadadNo(){

    }
    @OnNeverAskAgain({Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE})
    public void dadadNever() {

    }
    @Override
    protected void setUpData() {
        VideoFragmentPermissionsDispatcher.dadadWithCheck(this);

//        for (int i = 0; i < 10; i++) {
//            videoDetailBeans.add(new VideoDetailBean("ARV","testName叫个什么名字都好只要能凑够两行"+i,"dreamaple","视频","已关注","其他"));
//        }
//        videoFragmentRecyclerViewAdapter = new VideoFragmentRecyclerViewAdapter(videoDetailBeans);
        videoFragmentRecyclerViewAdapter = new VideoFragmentRecyclerViewAdapter(jsonObjects);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(videoFragmentRecyclerViewAdapter);
        videoFragmentRecyclerViewAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });

        NetworkUtil.getInsBilibili().create(VideoApi.class).recommend().enqueue(new CallBack(new CallBack.ACallBack() {
            @Override
            public void successed(JSONObject jsonObject) {
                jsonObjects = SpdUtils.fastJsonArray2List(jsonObject.getJSONArray("list"));
                LogUtil.e("aaaaaaaa");
                videoFragmentRecyclerViewAdapter.addData(jsonObjects);
                videoFragmentRecyclerViewAdapter.notifyDataSetChanged();
            }
        }));
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
