package com.example.android.tedxdtu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationFormActivity extends AppCompatActivity {

    private TEDxDTU_Service service;

    Boolean correct;
    LinearLayout success;
    ScrollView scrollView;
    TextView errorOne, errorTwo, errorThree, errorFour, apply;
    EditText one, two, three, four;
    String answerOne, answerTwo, answerThree, answerFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);

        service = API_Utils.getService();

        success = findViewById(R.id.after_success);
        success.setVisibility(View.GONE);

        scrollView = (ScrollView) findViewById(R.id.scroll_View_answers);

        errorOne = (TextView) findViewById(R.id.errorAnswerOne);
        errorOne.setVisibility(View.INVISIBLE);

        errorTwo = (TextView) findViewById(R.id.errorAnswerTwo);
        errorTwo.setVisibility(View.INVISIBLE);

        errorThree = (TextView) findViewById(R.id.errorAnswerThree);
        errorThree.setVisibility(View.INVISIBLE);

        errorFour = (TextView) findViewById(R.id.errorAnswerFour);
        errorFour.setVisibility(View.INVISIBLE);

        one = (EditText) findViewById(R.id.answerOne);
        two = (EditText) findViewById(R.id.answerTwo);
        three = (EditText) findViewById(R.id.answerThree);
        four = (EditText) findViewById(R.id.answerFour);

        apply = (TextView) findViewById(R.id.applyButton);

        service.getInfo().enqueue(new Callback<StatusResponse>() {
            @Override
            public void onResponse(Call<StatusResponse> call, Response<StatusResponse> response) {
                if (response.isSuccessful()) {

                    if (response.body().getData().getStatus().getQuestionnaire().getStatus().equals(true)) {

                        answerOne = response.body().getData().getStatus().getQuestionnaire().getAnswers().getWhyWantToAttend();
                        answerTwo = response.body().getData().getStatus().getQuestionnaire().getAnswers().getHowComeToKnow();
                        answerThree = response.body().getData().getStatus().getQuestionnaire().getAnswers().getWhyIdeaWorth();
                        // answerFour =

                        success.setVisibility(View.VISIBLE);

                        scrollView.setAlpha(0.5f);

                        one.setText(answerOne);
                        one.setEnabled(false);
                        one.setInputType(InputType.TYPE_NULL);

                        two.setText(answerTwo);
                        two.setEnabled(false);
                        two.setInputType(InputType.TYPE_NULL);

                        three.setText(answerThree);
                        three.setEnabled(false);
                        three.setInputType(InputType.TYPE_NULL);

                        four.setText(answerFour);
                        four.setEnabled(false);
                        four.setInputType(InputType.TYPE_NULL);

                        apply.setVisibility(View.INVISIBLE);

                    } else {

                        apply.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                errorOne.setVisibility(View.INVISIBLE);
                                errorTwo.setVisibility(View.INVISIBLE);
                                errorThree.setVisibility(View.INVISIBLE);
                                errorFour.setVisibility(View.INVISIBLE);
                                correct = true;

                                answerOne = one.getText().toString();
                                if (answerOne.equals("")) {
                                    errorOne.setVisibility(View.VISIBLE);
                                    correct = false;
                                }

                                answerTwo = two.getText().toString();
                                if (answerTwo.equals("")) {
                                    errorTwo.setVisibility(View.VISIBLE);
                                    correct = false;
                                }

                                answerThree = three.getText().toString();
                                if (answerThree.equals("")) {
                                    errorThree.setVisibility(View.VISIBLE);
                                    correct = false;
                                }

                                answerFour = four.getText().toString();
                                if (answerFour.equals("") || answerFour.length() != 10) {
                                    errorFour.setVisibility(View.VISIBLE);
                                    correct = false;
                                }

                                if (correct) {
                                    service.postQuestionnaire(answerOne, answerTwo, answerThree, answerFour).enqueue(new Callback<QuestionnairePostResponse>() {
                                        @Override
                                        public void onResponse(Call<QuestionnairePostResponse> call, Response<QuestionnairePostResponse> response) {
                                            if (response.isSuccessful()) {
                                                success.setVisibility(View.VISIBLE);
                                                scrollView.setAlpha(0.5f);
                                                scrollView.scrollTo(0, 0);

                                                one.setText(answerOne);
                                                one.setEnabled(false);
                                                one.setInputType(InputType.TYPE_NULL);

                                                two.setText(answerTwo);
                                                two.setEnabled(false);
                                                two.setInputType(InputType.TYPE_NULL);

                                                three.setText(answerThree);
                                                three.setEnabled(false);
                                                three.setInputType(InputType.TYPE_NULL);

                                                four.setText(answerFour);
                                                four.setEnabled(false);
                                                four.setInputType(InputType.TYPE_NULL);

                                                apply.setVisibility(View.INVISIBLE);
                                            }
                                        }

                                        @Override
                                        public void onFailure(Call<QuestionnairePostResponse> call, Throwable t) {

                                            Toast.makeText(RegistrationFormActivity.this,
                                                    "Please check your Internet Connection",
                                                    Toast.LENGTH_LONG);

                                            Log.d("Questionnaire_PostIssue", t.toString());
                                        }
                                    });
                                }


                            }
                        });
                    }
                }
            }

            @Override
            public void onFailure(Call<StatusResponse> call, Throwable t) {
                Toast.makeText(RegistrationFormActivity.this,
                        "Please check your Internet Connection",
                        Toast.LENGTH_LONG);

                Log.d("GetStatus_Issue", t.toString());
            }
        });
    }
}
