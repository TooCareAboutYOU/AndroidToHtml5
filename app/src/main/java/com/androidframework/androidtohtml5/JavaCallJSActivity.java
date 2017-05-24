package com.androidframework.androidtohtml5;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.Toast;

public class JavaCallJSActivity extends Activity implements View.OnClickListener {

    public static final String TAG="TAG";

    private EditText etAccount,etPwd;
    private WebView mWebView;
    private String account,pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_call_js);

        etAccount= (EditText) findViewById(R.id.et_account);
        etPwd= (EditText) findViewById(R.id.et_pwd);

        findViewById(R.id.btn_login).setOnClickListener(this);
        initWebView();

    }

    private void initWebView() {

        //加载网页-H5、html，自定义浏览器,直接在webview中播视频
        mWebView=new WebView(this);

        WebSettings mWebSettings=mWebView.getSettings();
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
        mWebView.loadUrl("file:///android_asset/phonelogin.html");

//        setContentView(mWebView);

    }

    class AndroidAndJsInterface{
        /**
         * 被js调用
         */
        @JavascriptInterface
        public void ShowToast(){ Toast.makeText(JavaCallJSActivity.this, "点击登录", Toast.LENGTH_SHORT).show(); }
    }

    @Override
    public void onClick(View v) {

        account=etAccount.getText().toString();
        pwd=etPwd.getText().toString();
        Log.i(TAG, "account1===="+account);
        login(account);
    }

    private void login(String account) {
        Log.i(TAG, "account2===="+account);
        mWebView.loadUrl("javascript:JavaCallJS("+"'"+account+"'"+")");
        setContentView(mWebView);
    }
}
