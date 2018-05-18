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

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

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

    private okhttp3.Response response;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

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

                /*if (username.equals("") || firstName.equals("") || lastName.equals("")
                        || email.equals("") || password.equals("")
                        || confirmPassword.equals("")) {
                    correct = false;
                    error.setVisibility(View.VISIBLE);
                }

                if (mobileNumber.equals("") || mobileNumber.length() != 10) {
                    correct = false;
                    error.setVisibility(View.VISIBLE);
                }

                if (!password.equals(confirmPassword)) {
                    correct = false;
                    errorPasswords.setVisibility(View.VISIBLE);
                }*/

                if (correct) {
                    Log.d("Register","in if correct");

                    LoginA runner = new LoginA();
                    runner.execute(username, email, password, confirmPassword);


                    /*OkHttpClient client = new OkHttpClient();
                    MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
                    RequestBody body = RequestBody.create(mediaType,
                            "username=testing9&email=uglybeast1010@gmail.com&password1=password&password2=password");
                    Request request = new Request.Builder()
                            .url("http://www.tedxdtu.in/api/v1/accounts/signup/")
                            .post(body)
                            .build();

                    client.newCall(request).enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {
                            String mMessage = e.getMessage();
                            Log.w("failure Response", mMessage);
                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            Log.d("Response Geneated", response.body().string());

                            if(response.isSuccessful()){
                                Log.d("Response Successful", response.code()+"");
                                if(response.code() == 200){
                                    Log.d("Response Correct", "Intent laga do plij");
                                } else {
                                    Log.d("Response Incorrect", "Hmm, response code " +
                                        response.code());
                                }
                            }
                        }
                    });*/


                }
            }
        });
    }

    public class LoginA extends AsyncTask<String, String, String> {
        ProgressDialog progressDialog;

        @Override
        protected String doInBackground(String... strings) {

            Log.d("Register", "background");

            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
            RequestBody body = RequestBody.create(mediaType,
                    "username=testing9&email=uglybeast1010@gmail.com&password1=password&password2=password");
            Request request = new Request.Builder()
                    .url("http://www.tedxdtu.in/api/v1/accounts/signup/")
                    .post(body)
                    .build();

            /*OkHttpClient httpClient = new OkHttpClient();
            String url = "http://www.zoftino.com/api/saveFavorite";

            HttpUrl.Builder httpBuider = HttpUrl.parse(url).newBuilder();
            httpBuider.addQueryParameter("coupon", "abcd");

            Request request = new Request.Builder().url(httpBuider.build()).build();

            response = null;*/

            Log.d("Register", "built successful");

            try {
                response = client.newCall(request).execute();
                Log.d("Register", response.body()+"");
                Log.d("Register", "response generated " + response.code() + ": " + response.message());


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
            Log.d("Register", "post");

                if (response.code() == 200) {
                    Log.d("Register", response.code() + "");
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);
                }

                if (response.code() == 400) {
                    correct = false;
                    Log.d("Register", response.code() + "\n" + response.toString());
                }

                if (response.code() > 500) {
                    Toast.makeText(getContext(),
                            "Please check your Internet Connection",
                            Toast.LENGTH_LONG);
                }

                Log.d("Register", response.body() + "");
        }
    }

    /*public static void main(String[] args){
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType,
                "username=testing9&email=uglybeast1010@gmail.com&password1=password&password2=password");
        Request request = new Request.Builder()
                .url("http://www.tedxdtu.in/api/v1/accounts/signup/")
                .post(body)
                .build();

        try {
            okhttp3.Response response = client.newCall(request).execute();
            Log.d("Register", response.body()+"");
            Log.d("Register", "response generated " + response.code() + ": " + response.message());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/
}


