package com.example.android.tedxdtu;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    private TEDxDTU_Service service;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        service = API_Utils.getService();

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

                if(emailString.equals("") || passwordString.equals("")){
                    correct = false;
                    errorLogin.setVisibility(View.VISIBLE);
                }

                if(correct){
                    service.normalLogin(emailString, passwordString).enqueue(new Callback<NormalLogin>() {
                        @Override
                        public void onResponse(Call<NormalLogin> call, Response<NormalLogin> response) {
                            if(response.isSuccessful()){
                                if(response.body().getStatus().getMessage().equals("success")){
                                    Intent intent = new Intent(getContext(), MainActivity.class);
                                    startActivity(intent);
                                } else if (response.body().getStatus().getMessage().equals("failure")){
                                    correct = false;
                                    errorLogin.setText(View.VISIBLE);
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<NormalLogin> call, Throwable t) {
                            Toast.makeText(getContext(),
                                    "Please check your Internet Connection",
                                    Toast.LENGTH_LONG);

                            Log.d("NormalLogin_Error", t.toString());
                        }
                    });
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
}
