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

import org.w3c.dom.Text;


public class RegisterFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    String username, firstName, lastName, email, mobileNumber, password, confirmPassword;
    EditText un, fn, ln, em, mobile, pass, conPass;
    TextView error;
    Boolean correct;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        error = (TextView) getView().findViewById(R.id.error_register);
        error.setVisibility(View.GONE);

        un = (EditText) getView().findViewById(R.id.username_register);
        fn = (EditText) getView().findViewById(R.id.first_name_register);
        ln = (EditText) getView().findViewById(R.id.last_name_register);
        em = (EditText) getView().findViewById(R.id.email_register);
        mobile = (EditText) getView().findViewById(R.id.mobile_register);
        pass = (EditText) getView().findViewById(R.id.password_register);
        conPass = (EditText) getView().findViewById(R.id.confirm_password_register);

        TextView register = (TextView) getView().findViewById(R.id.register_button);
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

                if(mobileNumber.equals("") || mobileNumber.length()!=10){
                    correct = false;
                }

                if(!password.equals(confirmPassword)){
                    correct = false;
                }

                if(correct){
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);
                } else {
                    error.setVisibility(View.VISIBLE);
                }
            }
        });

    }
}
