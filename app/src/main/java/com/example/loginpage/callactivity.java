package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class callactivity extends AppCompatActivity {
ImageView callimg;
TextView callername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callactivity);
        //call imageview -- Fake call module
    callimg=(ImageView)findViewById(R.id.callimg);
    callername=findViewById(R.id.callername);
    }
}