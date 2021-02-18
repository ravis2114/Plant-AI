package com.example.plantai;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class SplashActivity extends AppCompatActivity {

    public static int SPLASH_SCREEN = 3000;

    LottieAnimationView scifiView, plantView;
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        scifiView = findViewById(R.id.scifi_view);
        plantView = findViewById(R.id.plant_view);
        name = findViewById(R.id.name);

//        name.animate().translationY(-1600).setDuration(1000).setStartDelay(4000);
//        scifiView.animate().translationX(-1600).setDuration(1000).setStartDelay(4000);
//        plantView.animate().translationX(1600).setDuration(1000).setStartDelay(4000);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);

                Pair [] pair = new Pair[2];
                pair[0] = new Pair<View, String>(plantView, "plant_tran");
                pair[1] = new Pair<View, String>(name, "name_tran");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this, pair);

                startActivity(intent, options.toBundle());
                finish();
            }
        }, SPLASH_SCREEN);
    }
}