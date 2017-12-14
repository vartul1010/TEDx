package com.example.android.tedxdtu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar.LayoutParams;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

/**
 * Created by shreya on 14/12/17.
 */

public class Speakers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        final GridView galleryGrid = (GridView) findViewById(R.id.gallery_grid);
        galleryGrid.setAdapter(new ImageAdapter(this));
       final LinearLayout custom = (LinearLayout)findViewById(R.id.custom_bar);


       final Animation slideUpAnimation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up);
        ScrollView text = (ScrollView)findViewById(R.id.text1);
        final int height = text.getHeight();
        LinearLayout layout = (LinearLayout) findViewById(R.id.title);
        final int h2 = layout.getHeight();

        galleryGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(Speakers.this);
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.speakers_about, null);
                dialogView.clearAnimation();
                dialogView.setAnimation(slideUpAnimation);
                builder.setView(dialogView);
                builder.setCancelable(true);
                AlertDialog alert = builder.create();
                alert.show();
                alert.getWindow().setLayout(LayoutParams.WRAP_CONTENT,height+h2);
                            }
        });
    }


}
