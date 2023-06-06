package com.yogeshandroid.mycircle.Welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.yogeshandroid.mycircle.Login.LogIn;
import com.yogeshandroid.mycircle.databinding.ActivitySplashBinding;

public class Splash extends AppCompatActivity {
    ActivitySplashBinding binding;
    private static final String TAG = "TAG_SPLASH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Handler h = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Splash.this, LogIn.class);

                // fcm data payload
                if (getIntent() != null && getIntent().hasExtra("name")) {
                    Bundle bundle = new Bundle();
                    for (String key : getIntent().getExtras().keySet()) {
                        Log.d(TAG, "KEY - " + key + "          VALUE - " + getIntent().getExtras().get(key).toString());
                    }
                    bundle.putString("name", getIntent().getExtras().get("name").toString());
                    bundle.putString("age", getIntent().getExtras().get("age").toString());
                    bundle.putString("jagah", getIntent().getExtras().get("jagah").toString());
                    i.putExtras(bundle);
                }

                startActivity(i);
            }
        };
        h.postDelayed(runnable, 3000);
    }
}