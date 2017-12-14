package com.example.android.tedxdtu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.GridView;

public class PartnersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partners);

        GridView partnersGrid = (GridView) findViewById(R.id.partners_grid);
        partnersGrid.setAdapter(new com.example.android.tedxdtu.Adapter(this));
    }
}
