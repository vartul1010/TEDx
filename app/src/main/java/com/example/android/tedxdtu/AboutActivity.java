package com.example.android.tedxdtu;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class AboutActivity extends AppCompatActivity {
    double latitude = 28.7502522;
    double longitude = 77.1164258;
    String label = "B.R. Ambedkar Auditorium";
    String uriBegin = "geo:" + latitude + "," + longitude;
    String query = latitude + "," + longitude + "(" + label + ")";
    String encodedQuery = Uri.encode(query);
    String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
    Uri uri = Uri.parse(uriString);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

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
