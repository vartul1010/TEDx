package com.example.android.tedxdtu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import static com.example.android.tedxdtu.R.id.gallery;

public class GalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        GridView galleryGrid = (GridView) findViewById(R.id.gallery_grid);
        galleryGrid.setAdapter(new ImageAdapter(this));

        galleryGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent i = new Intent(getApplicationContext(), SingleViewActivity.class);
                i.putExtra("id", position);
                startActivity(i);
            }
        });
    }
}
