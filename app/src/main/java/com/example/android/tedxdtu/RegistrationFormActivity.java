package com.example.android.tedxdtu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class RegistrationFormActivity extends AppCompatActivity {

    Boolean correct;
    LinearLayout success;
    ScrollView scrollView;
    TextView errorOne, errorTwo, errorThree, errorFour;
    EditText one, two, three, four;
    String answerOne, answerTwo, answerThree, answerFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);

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

        TextView apply = (TextView) findViewById(R.id.applyButton);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                errorOne.setVisibility(View.INVISIBLE);
                errorTwo.setVisibility(View.INVISIBLE);
                errorThree.setVisibility(View.INVISIBLE);
                errorFour.setVisibility(View.INVISIBLE);
                correct = true;

                answerOne = one.getText().toString();
                if(answerOne.equals("")){
                    errorOne.setVisibility(View.VISIBLE);
                    correct = false;
                }

                answerTwo = two.getText().toString();
                if(answerTwo.equals("")){
                    errorTwo.setVisibility(View.VISIBLE);
                    correct = false;
                }

                answerThree = three.getText().toString();
                if(answerThree.equals("")){
                    errorThree.setVisibility(View.VISIBLE);
                    correct = false;
                }

                answerFour = four.getText().toString();
                if(answerFour.equals("") || answerFour.length()!=10){
                    errorFour.setVisibility(View.VISIBLE);
                    correct = false;
                }

                if(correct){
                    //send data via api
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
                }
            }
        });
    }
}
