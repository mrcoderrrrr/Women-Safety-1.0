package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ImageView;
import android.widget.TextView;

public class tipsfeed extends AppCompatActivity {
TextView tips;
ImageView car,online,home,parties,tarvel,shopping;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipsfeed);
        //display image of tips feed -- tips feed option from menubar of module page
        tips=(TextView)findViewById(R.id.tips);
        car=(ImageView) findViewById(R.id.incar);
        online=(ImageView) findViewById(R.id.online);
        home=(ImageView) findViewById(R.id.athome);
        parties=(ImageView) findViewById(R.id.inparties);
        tarvel=(ImageView) findViewById(R.id.tarvelling);
        shopping=(ImageView) findViewById(R.id.shopping);

    }
}