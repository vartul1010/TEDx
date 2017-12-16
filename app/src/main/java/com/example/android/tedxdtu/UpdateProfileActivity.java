package com.example.android.tedxdtu;

import android.graphics.Typeface;
import android.support.constraint.solver.SolverVariable.Type;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class UpdateProfileActivity extends AppCompatActivity {
    Typeface tfM, tfB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        tfM = Typeface.createFromAsset(this.getAssets(),"fonts/HindSiliguri-Medium.ttf");
        tfB = Typeface.createFromAsset(this.getAssets(),"fonts/HindSiliguri-Bold.ttf");


        TextView name,email,register_status;
        name = (TextView)findViewById(R.id.name_);
        name.setTypeface(tfB);

        email = (TextView)findViewById(R.id.email);
        email.setTypeface(tfM);

        register_status = (TextView)findViewById(R.id.register);
        register_status.setTypeface(tfB);

        TextView button = (TextView) findViewById(R.id.registration_form);
        button.setTypeface(tfB);

    }
}
