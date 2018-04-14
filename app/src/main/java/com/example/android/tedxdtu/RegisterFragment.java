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

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    String username, firstName, lastName, email, mobileNumber, password, confirmPassword;
    EditText un, fn, ln, em, mobile, pass, conPass;
    TextView error, errorPasswords;
    Boolean correct;

    private TEDxDTU_Service service;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        service = API_Utils.getService();

        error = (TextView) getView().findViewById(R.id.error_register);
        error.setVisibility(View.INVISIBLE);

        errorPasswords = (TextView) getView().findViewById(R.id.error_password);
        errorPasswords.setVisibility(View.GONE);

        un = (EditText) getView().findViewById(R.id.username_register);
        fn = (EditText) getView().findViewById(R.id.first_name_register);
        ln = (EditText) getView().findViewById(R.id.last_name_register);
        em = (EditText) getView().findViewById(R.id.email_register);
        mobile = (EditText) getView().findViewById(R.id.mobile_register);
        pass = (EditText) getView().findViewById(R.id.password_register);
        conPass = (EditText) getView().findViewById(R.id.confirm_password_register);

        final TextView register = (TextView) getView().findViewById(R.id.register_button);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correct = true;

                username = un.getText().toString();
                firstName = fn.getText().toString();
                lastName = ln.getText().toString();
                email = em.getText().toString();
                mobileNumber = mobile.getText().toString();
                password = pass.getText().toString();
                confirmPassword = conPass.getText().toString();

                if(username.equals("") || firstName.equals("") || lastName.equals("")
                        || email.equals("") || password.equals("")
                        || confirmPassword.equals("")){
                    correct = false;
                    error.setVisibility(View.VISIBLE);
                }

                if(mobileNumber.equals("") || mobileNumber.length()!=10){
                    correct = false;
                    error.setVisibility(View.VISIBLE);
                }

                if(!password.equals(confirmPassword)){
                    correct = false;
                    errorPasswords.setVisibility(View.VISIBLE);
                }

                if(correct){
                    service.normalRegister(username, email, password, confirmPassword).enqueue(new Callback<NormalRegister>() {
                        @Override
                        public void onResponse(Call<NormalRegister> call, Response<NormalRegister> response) {
                            if(response.isSuccessful()){
                                if(response.body().getStatus().getCode() == 200){
                                    Intent intent = new Intent(getContext(), MainActivity.class);
                                    startActivity(intent);
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<NormalRegister> call, Throwable t) {
                            Toast.makeText(getContext(),
                                    "Please check your Internet Connection",
                                    Toast.LENGTH_LONG);

                            Log.d("NormalRegister_Error", t.toString());
                        }
                    });
                }
            }
        });

    }
}
