package com.example.android.tedxdtu;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.constraint.solver.SolverVariable.Type;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class UpdateProfileActivity extends AppCompatActivity {
    Typeface tfM, tfB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);
        tfM = Typeface.createFromAsset(this.getAssets(),"fonts/HindSiliguri-Medium.ttf");
        tfB = Typeface.createFromAsset(this.getAssets(),"fonts/HindSiliguri-Bold.ttf");

        LinearLayout questionnaire = (LinearLayout) findViewById(R.id.questionnaire);
        questionnaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdateProfileActivity.this, RegistrationFormActivity.class);
                startActivity(intent);
            }
        });
    }
}
