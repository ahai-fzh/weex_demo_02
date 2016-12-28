package com.ahai.weex.demo02;

import android.app.Application;

import com.alibaba.weex.commons.adapter.ImageAdapter;
import com.taobao.weex.InitConfig;
import com.taobao.weex.WXSDKEngine;

/**
 * Created by zhenhai.fzh on 16/12/27.
 */

public class WXApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initWeexSdkEngine();
    }

    private void initWeexSdkEngine() {
        InitConfig initConfig = new InitConfig.Builder().setImgAdapter(new ImageAdapter()).build();
        WXSDKEngine.initialize(this, initConfig);
    }
}
