package com.dreamaple.baseutils.view;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.dreamaple.baseutils.R;

public class TopView extends Toolbar {
    public TopView(Context context) {
        super(context);
        init(context);
    }

    public TopView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TopView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.top_view, this, true);
//        findViewById(R.id.)
    }
}
