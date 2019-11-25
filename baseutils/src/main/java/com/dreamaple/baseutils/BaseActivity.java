package com.dreamaple.baseutils;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class BaseActivity extends AppCompatActivity implements BaseFragment.OnFragmentInteractionListener {
    BaseActivity baseActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager();
//        TextView textView = new TextView(this);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
