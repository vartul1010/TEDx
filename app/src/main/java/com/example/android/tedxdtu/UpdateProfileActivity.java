package com.example.android.tedxdtu;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.constraint.solver.SolverVariable.Type;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateProfileActivity extends AppCompatActivity {

    private TEDxDTU_Service service;
    Typeface tfM, tfB;

    TextView name, email;

    LinearLayout questionnaire, application, payment;

    ImageView ques_img, app_img, pay_img, ticket_img;

    String answerOne, answerTwo, answerThree, answerFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        service = API_Utils.getService();

        tfM = Typeface.createFromAsset(this.getAssets(),"fonts/HindSiliguri-Medium.ttf");
        tfB = Typeface.createFromAsset(this.getAssets(),"fonts/HindSiliguri-Bold.ttf");

        name = (TextView) findViewById(R.id.name);
        email = (TextView) findViewById(R.id.email);

        questionnaire = (LinearLayout) findViewById(R.id.questionnaire);
        application = (LinearLayout) findViewById(R.id.application);
        payment = (LinearLayout) findViewById(R.id.payment);

        ques_img = (ImageView) findViewById(R.id.success_questionnaire);
        app_img = (ImageView) findViewById(R.id.success_application);
        pay_img = (ImageView) findViewById(R.id.success_payment);

        ques_img.setVisibility(View.GONE);
        app_img.setVisibility(View.GONE);
        pay_img.setVisibility(View.GONE);
        ticket_img.setVisibility(View.GONE);

        service.getInfo().enqueue(new Callback<StatusResponse>() {
            @Override
            public void onResponse(Call<StatusResponse> call, Response<StatusResponse> response) {
                if(response.isSuccessful()) {

                    String nameResponse = response.body().getData().getUserDetails().getName();
                    name.setText(nameResponse);

                    String emailResponse = response.body().getData().getUserDetails().getEmail();
                    email.setText(emailResponse);

                    if(response.body().getData().getStatus().getQuestionnaire().getStatus().equals(true)){
                        questionnaire.setBackgroundResource(R.drawable.profile_button_var);
                        ques_img.setVisibility(View.VISIBLE);
                    }

                    if(response.body().getData().getStatus().getSelction().getStatus().equals(true)){
                        application.setBackgroundResource(R.drawable.profile_button_var);
                        app_img.setVisibility(View.VISIBLE);
                    }

                    if(response.body().getData().getStatus().getPayment().getStatus().equals(true)){
                        payment.setBackgroundResource(R.drawable.profile_button_var);
                        pay_img.setVisibility(View.VISIBLE);
                    }
                }
            }

            @Override
            public void onFailure(Call<StatusResponse> call, Throwable t) {
                Toast.makeText(UpdateProfileActivity.this,
                        "Please check your Internet Connection",
                        Toast.LENGTH_LONG);

                Log.d("GetStatus_Issue", t.toString());
            }
        });

        questionnaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdateProfileActivity.this, RegistrationFormActivity.class);
                intent.putExtra("answer1", answerOne);
                intent.putExtra("answer2", answerTwo);
                intent.putExtra("answer3", answerThree);
                intent.putExtra("answer4", answerFour);
                startActivity(intent);
            }
        });
    }
}
