package com.rifky.simlik.aktifitas;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by rifky on 07/05/17.
 */

public class SplashActivity extends AppCompatActivity {

    private final Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(SplashActivity.this, HalamanUtamaActivity.class);
            SplashActivity.this.startActivity(intent);
            SplashActivity.this.finish();
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Handler handler = new Handler();
        handler.postDelayed(mRunnable, 3000);
    }
}