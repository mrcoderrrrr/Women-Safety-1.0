package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.BatchUpdateException;

public class screamsound extends AppCompatActivity {
TextView screamtxt;
Button male,female,police;
MediaPlayer mp=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screamsound);
        screamtxt = (TextView) findViewById(R.id.screamtext);
        male = (Button) findViewById(R.id.male);
        female = (Button) findViewById(R.id.female);
        police = (Button) findViewById(R.id.police);
//male audio --  scream module
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp = MediaPlayer.create(screamsound.this, R.raw.man);
                mp.start();
            }
        });
        //female audio -- scream module
    female.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mp=MediaPlayer.create(screamsound.this,R.raw.woman);
            mp.start();
        }
    });
    //police audio - scream module
    police.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mp=MediaPlayer.create(screamsound.this,R.raw.policesiran);
            mp.start();
        }
    });
    }
}
