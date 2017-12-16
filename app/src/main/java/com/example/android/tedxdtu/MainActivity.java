package com.example.android.tedxdtu;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Typeface tfM ,tfB ;

    TextView welcome,sign_out,profile,ticket,ab,sp,th,pa,ga,co;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tfM = Typeface.createFromAsset(this.getAssets(),"fonts/HindSiliguri-Medium.ttf");
        tfB = Typeface.createFromAsset(this.getAssets(),"fonts/HindSiliguri-Bold.ttf");

        welcome = (TextView)findViewById(R.id.welcome);
        welcome.setTypeface(tfB);
        sign_out = (TextView)findViewById(R.id.sign_out);
        sign_out.setTypeface(tfB);
        profile = (TextView)findViewById(R.id.profile);
        profile.setTypeface(tfM);
        ticket = (TextView)findViewById(R.id.ticket);
        ticket.setTypeface(tfM);
        ab = (TextView)findViewById(R.id.ab);
        ab.setTypeface(tfM);
        sp = (TextView)findViewById(R.id.sp);
        sp.setTypeface(tfM);
        th = (TextView)findViewById(R.id.th);
        th.setTypeface(tfM);
        pa = (TextView)findViewById(R.id.pa);
        pa.setTypeface(tfM);
        ga = (TextView)findViewById(R.id.ga);
        ga.setTypeface(tfM);
        co = (TextView)findViewById(R.id.co);
        co.setTypeface(tfM);

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
                    Intent speakersIntent = new Intent(MainActivity.this, Speakers.class);
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
