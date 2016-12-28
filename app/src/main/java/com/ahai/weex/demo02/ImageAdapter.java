package com.ahai.weex.demo02;

import android.util.Log;
import android.widget.ImageView;

import com.taobao.weex.adapter.IWXImgLoaderAdapter;
import com.taobao.weex.common.WXImageStrategy;
import com.taobao.weex.dom.WXImageQuality;

/**
 * Created by zhenhai.fzh on 16/12/27.
 */

public class ImageAdapter implements IWXImgLoaderAdapter {

    String TAG = "ImageAdapter";

    @Override
    public void setImage(String url, ImageView view, WXImageQuality quality, WXImageStrategy strategy) {
        //实现你自己的图片下载，否则图片无法显示。
        Log.d(TAG, "setImage url="+url);
    }
}
