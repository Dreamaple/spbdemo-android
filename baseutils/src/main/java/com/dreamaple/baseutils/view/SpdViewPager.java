package com.dreamaple.baseutils.view;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Display;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.dreamaple.baseutils.BaseActivity;
import com.dreamaple.baseutils.SpdUtils;

public class SpdViewPager extends ViewPager {
    public SpdViewPager(@NonNull Context context) {
        super(context);
    }

    public SpdViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }




    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Point p = new Point();
        getDisplay().getSize(p);
        Rect frame = new Rect();
        ((BaseActivity)getContext()).getWindow().getDecorView().getWindowVisibleDisplayFrame(frame);
        int statusBarHeight = frame.top;
//        int expandSpec = MeasureSpec.makeMeasureSpec(p.y-statusBarHeight- SpdUtils.getNavigationBarHeight(getContext())
//                , MeasureSpec.AT_MOST);
        int expandSpec = MeasureSpec.makeMeasureSpec(frame.bottom - frame.top - SpdUtils.getNavigationBarHeight(getContext())
                , MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }










//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        Point p = new Point();
//        getDisplay().getSize(p);
//        int expandSpec = MeasureSpec.makeMeasureSpec(p.y
//                , MeasureSpec.AT_MOST);
//        super.onMeasure(widthMeasureSpec, expandSpec);
//    }
}
