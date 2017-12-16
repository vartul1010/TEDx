package com.example.android.tedxdtu;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ThemeActivity extends AppCompatActivity {

    Typeface tfM, tfB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        tfM = Typeface.createFromAsset(this.getAssets(),"fonts/HindSiliguri-Medium.ttf");
        tfB = Typeface.createFromAsset(this.getAssets(),"fonts/HindSiliguri-Bold.ttf");


        setContentView(R.layout.activity_theme);

        TextView theme,content;
        theme = (TextView)findViewById(R.id.theme);
        theme.setTypeface(tfB);

        content = (TextView)findViewById(R.id.th_content);
        content.setTypeface(tfM);


    }
}
