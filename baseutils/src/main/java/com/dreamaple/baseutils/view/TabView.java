package com.dreamaple.baseutils.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.dreamaple.baseutils.R;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;

public class TabView extends LinearLayout implements ViewPager2.PageTransformer {
    TabLayout tabLayout;
    ViewPager2 viewPager2;

    public TabView(Context context) {
        super(context);
        init(context);
    }

    public TabView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TabView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array=context.obtainStyledAttributes(attrs, R.styleable.TabView);
        array.recycle();
        init(context);
    }
    public void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.tab_view, this, true);
        tabLayout = findViewById(R.id.tabview_tablayout);
        viewPager2 = findViewById(R.id.tabview_viewpager2);

        viewPager2.setPageTransformer(this);

//        tabLayout.setupWithViewPager(viewPager2,false);



    }


    @Override
    public void transformPage(@NonNull View page, float position) {

    }
}
