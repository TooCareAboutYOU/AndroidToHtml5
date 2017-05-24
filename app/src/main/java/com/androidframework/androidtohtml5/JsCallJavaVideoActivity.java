package com.androidframework.androidtohtml5;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class JsCallJavaVideoActivity extends Activity {

    private WebView mWebView;
    private WebSettings mWebSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js_call_java_video);
        mWebView= (WebView) findViewById(R.id.wv_video);

        mWebSettings=mWebView.getSettings();
        //设置支持js
        mWebSettings.setJavaScriptEnabled(true);

        //不调用系统浏览器,自定义浏览器
        mWebView.setWebViewClient(new WebViewClient());

        //js调用JAVA
        //添加JavascriptInterface
        //以后js通过android字段调用这个类中任何方法
        mWebView.addJavascriptInterface(new AndroidAndJsInterface(),"android");

        //加载网络的网页
        //mWebView.loadUrl("http://www.atguigu.com/");
        //加载本地网页
        mWebView.loadUrl("file:///android_asset/RealNetJSCallJavaActivity.htm");
    }

    class AndroidAndJsInterface{
        /**
         * 被js调用
         */
        @JavascriptInterface
        public void playVideo(int id,String videoUrl,String tittle){
            //把系统所有的播放器调用起来
            //  http://api.m.mtime.cn/PageSubArea/TrailerList.api  视屏播放地址json, 在html中添加播放地址
            Intent intent=new Intent();
            intent.setDataAndType(Uri.parse(videoUrl),"video/*");
            startActivity(intent);
        }
    }
}
