package com.example.android.tedxdtu;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class LoginFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    String emailString, passwordString;
    EditText email, password;
    TextView errorLogin;
    Boolean correct;
    private okhttp3.Response response;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        errorLogin = (TextView) getView().findViewById(R.id.error_login);
        errorLogin.setVisibility(View.GONE);

        email = (EditText) getView().findViewById(R.id.email_login);
        password = (EditText) getView().findViewById(R.id.password_login);


        final TextView login = (TextView) getView().findViewById(R.id.login_button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correct = true;

                emailString = email.getText().toString();
                passwordString = password.getText().toString();

                if (emailString.equals("") || passwordString.equals("")) {
                    correct = false;
                    errorLogin.setVisibility(View.VISIBLE);
                }

                if (correct) {
                    Log.d("Login","in if correct");
                    LoginA runner = new LoginA();
                    runner.execute(emailString, passwordString);
                }
            }

        });


        TextView loginGoogle = (TextView) getView().findViewById(R.id.login_using_google_button);
        loginGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO
                //api checkpoint if failed correct=false and show errorTextView
            }
        });
    }

    public class LoginA extends AsyncTask<String, String, String> {
        ProgressDialog progressDialog;

        @Override
        protected String doInBackground(String... strings) {

            Log.d("Login",  "background");
                OkHttpClient client = new OkHttpClient();
                MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
                RequestBody body = RequestBody.create(mediaType,
                        "username=" + strings[0] + "&password=" + strings[1]);
                Request request = new Request.Builder()
                        .url("http://tedxdtu.in/api/v1/accounts/get_token")
                        .post(body)
                        .addHeader("content-type", "application/x-www-form-urlencoded")
                        .addHeader("cache-control", "no-cache")
                        .addHeader("postman-token", "c88fbbcd-9199-22d5-6851-89753b57f676")
                        .build();
            Log.d("Login",  "built successful");

                try {
                    response = client.newCall(request).execute();
                    Log.d("Login",  "response generated "+response.code()+": "+response.message());

                } catch (IOException e) {
                    e.printStackTrace();
                }

            return response.code() + "";

        }

        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(getContext(),
                    "ProgressDialog",
                    "Please Wait ");
        }

        @Override
        protected void onPostExecute(String o) {
            progressDialog.dismiss();
            Log.d("Login",  "post");

            if (response.isSuccessful()) {
                Log.d("Login", emailString);
                Log.d("Login", response.body() + "");

                if (response.code() == 200) {
                    Log.d("Login", response.code() + "");
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);
                }

                if (response.code() == 400) {
                    correct = false;
                    Log.d("Login", emailString);
                }

                if (response.code() > 500) {
                    Toast.makeText(getContext(),
                            "Please check your Internet Connection",
                            Toast.LENGTH_LONG);
                }

                Log.d("Login", response.body() + "");

            }
        }
    }
}
