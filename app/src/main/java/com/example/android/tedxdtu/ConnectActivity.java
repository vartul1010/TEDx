package com.example.android.tedxdtu;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

import de.cketti.mailto.EmailIntentBuilder;

public class ConnectActivity extends AppCompatActivity {
    double latitude = 28.7502522;
    double longitude = 77.1164258;
    String label = "B.R. Ambedkar Auditorium";
    String uriBegin = "geo:" + latitude + "," + longitude;
    String query = latitude + "," + longitude + "(" + label + ")";
    String encodedQuery = Uri.encode(query);
    String uriString = uriBegin + "?q=" + encodedQuery + "&z=16";
    Uri uri = Uri.parse(uriString);

    AlertDialog.Builder builder;
    LayoutInflater inflater;
    View dialogView;
    TextView call_, mail_, connect_, location_;

    Typeface tfM, tfB;

    private LinearLayout phone, mail, connect_with, location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tfM = Typeface.createFromAsset(this.getAssets(), "fonts/HindSiliguri-Medium.ttf");
        tfB = Typeface.createFromAsset(this.getAssets(), "fonts/HindSiliguri-Bold.ttf");

        setContentView(R.layout.activity_connect);
        phone = (LinearLayout) findViewById(R.id.call_us);
        mail = (LinearLayout) findViewById(R.id.mail_us);
        connect_with = (LinearLayout) findViewById(R.id.connect_with_us);
        location = (LinearLayout) findViewById(R.id.location);

        call_ = (TextView) findViewById(R.id.call_textView);
        mail_ = (TextView) findViewById(R.id.mail_textView);
        connect_ = (TextView) findViewById(R.id.connect_textView);
        location_ = (TextView) findViewById(R.id.location_textView);

        call_.setTypeface(tfM);
        mail_.setTypeface(tfM);
        connect_.setTypeface(tfM);
        location_.setTypeface(tfM);

        builder = new AlertDialog.Builder(ConnectActivity.this);
        inflater = getLayoutInflater();

        phone.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                final String[] phone = new String[2];
                phone[0] = "+918373920868";
                phone[1] = "+918586096079";

                dialogView = inflater.inflate(R.layout.phone_dialog, null);
                builder.setView(dialogView);
                TextView text1 = (TextView) dialogView.findViewById(R.id.number1);
                text1.setText(phone[0]);
                text1.setTypeface(tfM);
                TextView text2 = (TextView) dialogView.findViewById(R.id.number2);
                text2.setText(phone[1]);
                text2.setTypeface(tfM);
                text1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:" + phone[0]));
                        startActivity(intent);

                    }
                });

                text2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:" + phone[1]));
                        startActivity(intent);
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();

            }
        });

        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EmailIntentBuilder.from(ConnectActivity.this)
                        .to("contact@tedxdtu.in")
                        .subject("Support TEDxDTU")
                        .start();
            }
        });

        location.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        connect_with.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = inflater.inflate(R.layout.connect_with_dialog, null);
                TextView face, web, tweet, snap, link, insta;
                face = (TextView) dialogView.findViewById(R.id.facebook);
                web = (TextView) dialogView.findViewById(R.id.website);
                tweet = (TextView) dialogView.findViewById(R.id.twitter);
                link = (TextView) dialogView.findViewById(R.id.linkedin);
                insta = (TextView) dialogView.findViewById(R.id.instagram);
                snap = (TextView) dialogView.findViewById(R.id.snapchat);

                face.setTypeface(tfM);
                web.setTypeface(tfM);
                tweet.setTypeface(tfM);
                link.setTypeface(tfM);
                insta.setTypeface(tfM);
                snap.setTypeface(tfM);

                builder.setView(dialogView);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

}
