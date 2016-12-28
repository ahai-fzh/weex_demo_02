package com.ahai.weex.demo02;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;
import com.taobao.weex.utils.WXFileUtils;

/**
 * Created by zhenhai.fzh on 16/12/27.
 */

public class MainActivity extends AppCompatActivity {

    final String BASE_URL = "http://30.96.224.23:8080/weex/";
    String path1 = "ahai/test.js";
    String path2 = "ahai/anjuke.js";
    WXSDKInstance wxsdkInstance;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWeexSdkInstance();
//        renderLocalJs();
        renderRemoteJs();
    }

    private void initWeexSdkInstance() {
        wxsdkInstance = new WXSDKInstance(this);
        wxsdkInstance.registerRenderListener(renderListener);
    }

    private void renderLocalJs() {
        String content = WXFileUtils.loadAsset("hello.js", this);
        wxsdkInstance.render(getPageName(), content, null, null, -1, -1, WXRenderStrategy.APPEND_ASYNC);
    }

    private void renderRemoteJs() {
        String url = BASE_URL + path2;
        wxsdkInstance.renderByUrl(getPageName(), url, null, null,
                getResources().getDisplayMetrics().widthPixels, -1, WXRenderStrategy.APPEND_ASYNC);
        // 宽度-1改成getResources().getDisplayMetrics().widthPixels否则在android手机上ui显示不正常。
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(wxsdkInstance != null) {
            wxsdkInstance.onActivityResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(wxsdkInstance != null) {
            wxsdkInstance.onActivityPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(wxsdkInstance != null) {
            wxsdkInstance.onActivityStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(wxsdkInstance != null) {
            wxsdkInstance.onActivityDestroy();
        }
    }

    IWXRenderListener renderListener = new IWXRenderListener() {
        @Override
        public void onViewCreated(WXSDKInstance instance, View view) {
            setContentView(view);
        }

        @Override
        public void onRenderSuccess(WXSDKInstance instance, int width, int height) {

        }

        @Override
        public void onRefreshSuccess(WXSDKInstance instance, int width, int height) {

        }

        @Override
        public void onException(WXSDKInstance instance, String errCode, String msg) {

        }
    };

    private String getPageName() {
        return "weex_demo_02";
    }
}
