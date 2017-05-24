package com.androidframework.androidtohtml5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_java_to_h5).setOnClickListener(this);
        findViewById(R.id.btn_h5_video).setOnClickListener(this);
        findViewById(R.id.btn_h5_phone).setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_java_to_h5:
                startActivity(new Intent(this,JavaCallJSActivity.class));
                break;
            case R.id.btn_h5_video:
                startActivity(new Intent(this,JsCallJavaVideoActivity.class));
                break;
            case R.id.btn_h5_phone:
                startActivity(new Intent(this,JsCallTelephoneActivity.class));
                break;
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
