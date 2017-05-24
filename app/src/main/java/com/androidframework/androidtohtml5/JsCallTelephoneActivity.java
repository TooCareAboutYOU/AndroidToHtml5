package com.androidframework.androidtohtml5;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class JsCallTelephoneActivity extends Activity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js_call_telephone);
        mWebView= (WebView) findViewById(R.id.wv_telephone);
        WebSettings webSettings = mWebView.getSettings();
        //设置支持javaScript脚步语言
        webSettings.setJavaScriptEnabled(true);

        //支持双击-前提是页面要支持才显示
//        webSettings.setUseWideViewPort(true);

        //支持缩放按钮-前提是页面要支持才显示
        webSettings.setBuiltInZoomControls(true);

        //设置客户端-不跳转到默认浏览器中
        mWebView.setWebViewClient(new WebViewClient());

        //设置支持js调用java
        mWebView.addJavascriptInterface(new AndroidAndJsInterface(), "Android");

        //加载本地资源
//        webView.loadUrl("http://atguigu.com/teacher.shtml");
        mWebView.loadUrl("file:///android_asset/JsCallJavaCallPhone.html");
    }

    class AndroidAndJsInterface {
        /**
         * 该方法将被js调用,用于加载数据
         */
        @JavascriptInterface
        public void showcontacts() {
            // 下面的代码建议在子线程中调用
            String json = "[{\"name\":\"阿福\", \"phone\":\"18600012345\"}]";
            // 调用JS中的方法
            mWebView.loadUrl("javascript:show('" + json + "')");
        }

        /**
         * 拨打电话
         * @param phone
         */
//        @JavascriptInterface
//        public void call(String phone) {
//            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
//            if (ActivityCompat.checkSelfPermission(JsCallJavaCallPhoneActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
//                return;
//            }
//            startActivity(intent);
//
//        }
    }
}
