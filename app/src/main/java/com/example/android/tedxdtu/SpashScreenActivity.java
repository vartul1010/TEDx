package com.example.android.tedxdtu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class SpashScreenActivity extends Activity {

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }

    Animation.AnimationListener animationListener = new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            Intent intent = new Intent(SpashScreenActivity.this, MainActivity.class);
            startActivity(intent);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spash_screen);

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.anim);
        anim.setAnimationListener(animationListener);
        anim.reset();

        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.lin_lay);
        linearLayout.clearAnimation();
        linearLayout.startAnimation(anim);

        ImageView imageView = (ImageView) findViewById(R.id.logo);
        imageView.clearAnimation();
        imageView.startAnimation(anim);

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        progressBar.clearAnimation();
        progressBar.startAnimation(anim);
    }

}
