package com.dreamaple.baseutils;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class GlideUtil {
    public static void setImg(Context context,String url,ImageView img) {
        Glide.with(context)
                .load(url)
                .placeholder(R.drawable.loading)
                .error(R.drawable.glide_error)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(img);
    }
}
