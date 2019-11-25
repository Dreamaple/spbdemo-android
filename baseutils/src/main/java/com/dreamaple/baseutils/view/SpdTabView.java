package com.dreamaple.baseutils.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.dreamaple.baseutils.BaseActivity;
import com.dreamaple.baseutils.BaseFragment;
import com.dreamaple.baseutils.LogUtil;
import com.dreamaple.baseutils.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class SpdTabView extends LinearLayout implements ViewPager2.PageTransformer {
    TabLayout tabLayout;
    SpdViewPager viewPager;
    List<String> tabLabel = new ArrayList<>();
    List<BaseFragment> fragmentList = new ArrayList<>();
    List<ListBean> listBeans = new ArrayList<>();

    public void setListBeans(List<ListBean> listBeans) {
        this.listBeans = listBeans;
        tabLabel.clear();
        fragmentList.clear();
        for (ListBean listBean : listBeans) {
            tabLabel.add(listBean.label);
            fragmentList.add(listBean.baseFragment);
        }
        myFragmentPagerAdapter.notifyDataSetChanged();
    }

    public MyFragmentPagerAdapter getMyFragmentPagerAdapter() {
        return myFragmentPagerAdapter;
    }

    MyFragmentPagerAdapter myFragmentPagerAdapter;

    public void setData(List<String> tabLabel,List<BaseFragment> fragmentList) {
        this.tabLabel = tabLabel;
        this.fragmentList = fragmentList;
        myFragmentPagerAdapter.notifyDataSetChanged();
    }

    public List<String> getTabLabel() {
        return tabLabel;
    }

    public List<BaseFragment> getFragmentList() {
        return fragmentList;
    }


    public SpdTabView(Context context) {
        this(context, null);
    }

    public SpdTabView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SpdTabView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array=context.obtainStyledAttributes(attrs, R.styleable.SpdTabView);
        array.recycle();
        init(context);
//        this.context = context;
    }
    public void init(Context context) {
        myFragmentPagerAdapter = new MyFragmentPagerAdapter(((BaseActivity) context).getSupportFragmentManager());
        LayoutInflater.from(context).inflate(R.layout.tab_view, this, true);
        tabLayout = findViewById(R.id.tabview_tablayout);
        viewPager = findViewById(R.id.tabview_viewpager);
        viewPager.setAdapter(myFragmentPagerAdapter);
        viewPager.setOffscreenPageLimit(1);
        tabLayout.setupWithViewPager(viewPager);
    }


    @Override
    public void transformPage(@NonNull View page, float position) {

    }

    class MyFragmentPagerAdapter extends FragmentPagerAdapter {


        public MyFragmentPagerAdapter(@NonNull FragmentManager fm) {
            this(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        public MyFragmentPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return tabLabel.get(position);
        }

    }
    class ListBean{
        String label;
        BaseFragment baseFragment;

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public BaseFragment getBaseFragment() {
            return baseFragment;
        }

        public void setBaseFragment(BaseFragment baseFragment) {
            this.baseFragment = baseFragment;
        }

    }
}
