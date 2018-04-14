package com.example.android.tedxdtu;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Typeface tfM ,tfB ;

    TextView welcome,ab,sp,th,pa,ga,co;

    private TEDxDTU_Service service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        service = API_Utils.getService();

        tfM = Typeface.createFromAsset(this.getAssets(),"fonts/HindSiliguri-Medium.ttf");
        tfB = Typeface.createFromAsset(this.getAssets(),"fonts/HindSiliguri-Bold.ttf");

        welcome = (TextView)findViewById(R.id.welcome);

        service.getInfo().enqueue(new Callback<StatusResponse>() {
            @Override
            public void onResponse(Call<StatusResponse> call, Response<StatusResponse> response) {
                if (response.isSuccessful()){
                    String name = response.body().getData().getUserDetails().getName();
                    String welcomeText = "Hello " + name + "!";
                    welcome.setText(welcomeText);
                }
            }

            @Override
            public void onFailure(Call<StatusResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this,
                        "Please check your Internet Connection",
                        Toast.LENGTH_LONG);

                Log.d("GetStatus_Issue", t.toString());
            }
        });

        welcome.setTypeface(tfM);
        ab = (TextView)findViewById(R.id.ab);
        ab.setTypeface(tfM);
        sp = (TextView)findViewById(R.id.sp);
        sp.setTypeface(tfM);
        th = (TextView)findViewById(R.id.th);
        th.setTypeface(tfM);
        pa = (TextView)findViewById(R.id.pa);
        pa.setTypeface(tfM);
        ga = (TextView)findViewById(R.id.ga);
        ga.setTypeface(tfM);
        co = (TextView)findViewById(R.id.co);
        co.setTypeface(tfM);

        RelativeLayout about = (RelativeLayout) findViewById(R.id.about);
        if(about != null){
            about.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent aboutIntent = new Intent(MainActivity.this, AboutActivity.class);
                    startActivity(aboutIntent);
                }
            });
        }

        RelativeLayout speakers = (RelativeLayout) findViewById(R.id.speakers);
        if(speakers != null){
            speakers.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent speakersIntent = new Intent(MainActivity.this, Speakers.class);
                    startActivity(speakersIntent);
                }
            });
        }

        RelativeLayout gallery = (RelativeLayout) findViewById(R.id.gallery);
        if(gallery != null){
            gallery.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent galleryIntent = new Intent(MainActivity.this, GalleryActivity.class);
                    startActivity(galleryIntent);
                }
            });
        }

        RelativeLayout theme = (RelativeLayout) findViewById(R.id.theme);
        if(theme != null){
            theme.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent themeIntent = new Intent(MainActivity.this, ThemeActivity.class);
                    startActivity(themeIntent);
                }
            });
        }

        RelativeLayout connect = (RelativeLayout) findViewById(R.id.connect);
        if(connect != null){
            connect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent connectIntent = new Intent(MainActivity.this, ConnectActivity.class);
                    startActivity(connectIntent);
                }
            });
        }

        RelativeLayout partners = (RelativeLayout) findViewById(R.id.partners);
        if(partners != null){
            partners.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent partnersIntent = new Intent(MainActivity.this, PartnersActivity.class);
                    startActivity(partnersIntent);
                }
            });
        }

        CircleImageView profile = (CircleImageView) findViewById(R.id.profile_icon);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UpdateProfileActivity.class);
                startActivity(intent);
            }
        });

    }
}
