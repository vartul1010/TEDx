package com.example.android.tedxdtu;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import org.w3c.dom.Text;

public class AboutActivity extends AppCompatActivity {
    double latitude = 28.7502522;
    double longitude = 77.1164258;
    String label = "B.R. Ambedkar Auditorium";
    String uriBegin = "geo:" + latitude + "," + longitude;
    String query = latitude + "," + longitude + "(" + label + ")";
    String encodedQuery = Uri.encode(query);
    String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
    Uri uri = Uri.parse(uriString);

    Typeface tfM ;
    Typeface tfB ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tfM = Typeface.createFromAsset(this.getAssets(),"fonts/HindSiliguri-Medium.ttf");
        tfB = Typeface.createFromAsset(this.getAssets(),"fonts/HindSiliguri-Bold.ttf");

        setContentView(R.layout.activity_about);
        TextView about,details;
        about = (TextView) findViewById(R.id.about);
        details = (TextView) findViewById(R.id.details);

        about.setTypeface(tfM);
        details.setTypeface(tfM);

        LinearLayout mapImage = (LinearLayout) findViewById(R.id.map_image);
        if (mapImage != null) {
            mapImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });
        }
    }

}
