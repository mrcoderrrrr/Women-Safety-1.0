package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class aboutapp extends AppCompatActivity {
TextView abouttext,aboutinfo1,aboutinfo2,aboutinfo3,aboutinfo4,aboutinfo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutapp);
        //display about app -- option from menubar of module page
        abouttext=(TextView)findViewById(R.id.abouttext);
        aboutinfo1=(TextView)findViewById(R.id.aboutinfo1);
        aboutinfo2=(TextView)findViewById(R.id.aboutinfo2);
        aboutinfo3=(TextView)findViewById(R.id.aboutinfo3);
        aboutinfo4=(TextView)findViewById(R.id.aboutinfo4);
        aboutinfo5=(TextView)findViewById(R.id.aboutinfo5);
    }
}