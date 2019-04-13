package com.lyd.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.lyd.projectoforacle.R;

public class SplashActivity extends Activity {
    private static final long DELAY_TIME=3000L;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,Login.class));
                finish();
            }
        },DELAY_TIME);
    }
}
