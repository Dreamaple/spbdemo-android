package com.dreamaple.baseutils;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.dreamaple.baseutils.view.BaseWebView;

public class WebActivity extends AppCompatActivity {

    BaseWebView baseWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
