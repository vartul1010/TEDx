package com.example.android.tedxdtu;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class LoginFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container,false);
    }

    String emailString, passwordString;
    EditText email, password;
    TextView errorLogin;
    Boolean correct;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        errorLogin = (TextView) getView().findViewById(R.id.error_login);
        errorLogin.setVisibility(View.GONE);

        email = (EditText) getView().findViewById(R.id.email_login);
        password = (EditText) getView().findViewById(R.id.password_login);

        TextView login = (TextView) getView().findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailString = email.getText().toString();
                passwordString = password.getText().toString();
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        TextView loginGoogle = (TextView) getView().findViewById(R.id.login_using_google_button);
        loginGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correct = true;

                emailString = email.getText().toString();
                passwordString = password.getText().toString();

                //api checkpoint if failed correct=false and show errorTextView

                if(correct) {
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);
                } else {
                    errorLogin.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
