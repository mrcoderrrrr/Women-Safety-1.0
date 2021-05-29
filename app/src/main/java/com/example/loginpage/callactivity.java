package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class callactivity extends AppCompatActivity {
ImageView callimg;
TextView callname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callactivity);
        //call imageview -- Fake call module
        String str=getIntent().getStringExtra("callersname");
    callimg=(ImageView)findViewById(R.id.callimg);
    callname=(TextView)findViewById(R.id.callernames);
    callname.setText(str);
    }
}