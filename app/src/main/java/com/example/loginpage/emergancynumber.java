package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.URI;

public class emergancynumber extends AppCompatActivity {
TextView emergencytxt;
Button ambulance,womenhelp,ncq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergancynumber);
    emergencytxt=(TextView)findViewById(R.id.emergancytext);
    ambulance=(Button)findViewById(R.id.ambulance);
    womenhelp=(Button)findViewById(R.id.womenhelp);
    ncq=(Button)findViewById(R.id.ncq);
setAmbulance();
setWomenhelp();
setNcq();
    }

    //ambulance number --- Emergency call Module
    public void setAmbulance(){
        ambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:102"));
                startActivity(intent);

            }
        });
    }
//women helpline -- Emergency call Module
    public void setWomenhelp(){
        womenhelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:1091"));
                startActivity(intent);

            }
        });
    }
//ncq number -- Emergency call Module
    public void setNcq(){
        ncq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:011-26942369"));
                startActivity(intent);

            }
        });
    }
}