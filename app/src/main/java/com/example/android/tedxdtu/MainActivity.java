package com.example.android.tedxdtu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RelativeLayout about = (RelativeLayout) findViewById(R.id.about);
        if(about != null){
            about.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent aboutIntent = new Intent(MainActivity.this, AboutActivity.class);
                    startActivity(aboutIntent);
                }
            });
        }

        RelativeLayout speakers = (RelativeLayout) findViewById(R.id.speakers);
        if(speakers != null){
            speakers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent speakersIntent = new Intent(MainActivity.this, SpeakersActivity.class);
                    startActivity(speakersIntent);
                }
            });
        }

        RelativeLayout gallery = (RelativeLayout) findViewById(R.id.gallery);
        if(gallery != null){
            gallery.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent galleryIntent = new Intent(MainActivity.this, GalleryActivity.class);
                    startActivity(galleryIntent);
                }
            });
        }

        RelativeLayout theme = (RelativeLayout) findViewById(R.id.theme);
        if(theme != null){
            theme.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent themeIntent = new Intent(MainActivity.this, ThemeActivity.class);
                    startActivity(themeIntent);
                }
            });
        }

        RelativeLayout connect = (RelativeLayout) findViewById(R.id.connect);
        if(connect != null){
            connect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent connectIntent = new Intent(MainActivity.this, ConnectActivity.class);
                    startActivity(connectIntent);
                }
            });
        }

        RelativeLayout partners = (RelativeLayout) findViewById(R.id.partners);
        if(partners != null){
            partners.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent partnersIntent = new Intent(MainActivity.this, PartnersActivity.class);
                    startActivity(partnersIntent);
                }
            });
        }

        LinearLayout profile = (LinearLayout) findViewById(R.id.update_profile);
        if(profile != null){
            profile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent profileIntent = new Intent(MainActivity.this, UpdateProfileActivity.class);
                    startActivity(profileIntent);
                }
            });
        }
    }
}
