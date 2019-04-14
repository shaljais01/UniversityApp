package com.example.random;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.widget.TextView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;


public class StudentProfileActivity extends AppCompatActivity {

    TextView textView8,textView9,textView10,textView11,textView12,textView13,
    textView14,textView15,textView16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp);

        textView8=(TextView)findViewById(R.id.textView8);
        textView9=(TextView)findViewById(R.id.textView9);
        textView10=(TextView)findViewById(R.id.textView10);
        textView11=(TextView)findViewById(R.id.textView11);
        textView12=(TextView)findViewById(R.id.textView12);
        textView13=(TextView)findViewById(R.id.textView13);
        textView14=(TextView)findViewById(R.id.textView14);
        textView15=(TextView)findViewById(R.id.textView15);
        textView16=(TextView)findViewById(R.id.textView16);



         String s1=(getIntent().getStringExtra("Roll no"));
       String s2=(getIntent().getStringExtra("email"));
        String s3=(getIntent().getStringExtra("name"));
        String s4=(getIntent().getStringExtra("branch"));
        String s5=(getIntent().getStringExtra("dsm"));
        String s6=(getIntent().getStringExtra("mm"));
        String s7=(getIntent().getStringExtra("oopsm"));
        String s8=(getIntent().getStringExtra("adem"));
       String s9=(getIntent().getStringExtra("dbmsm"));

       textView8.setText(s1);
       textView9.setText(s2);
       textView10.setText(s3);
       textView11.setText(s4);
       textView12.setText(s5);
       textView13.setText(s6);
       textView14.setText(s7);
       textView15.setText(s8);
       textView16.setText(s9);



    }
}
