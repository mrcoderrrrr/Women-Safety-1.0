package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

public class splashscreen extends AppCompatActivity {
    TextView womensafe;
    ImageView womenlogo;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
    womenlogo=(ImageView)findViewById(R.id.frame);
    womensafe=(TextView)findViewById(R.id.women_safet);
    //splash screen -- Animation
    handler=new Handler();
    handler.postDelayed(new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(splashscreen.this,MainActivity.class));
            finish();
        }
    },2000);
    }
}