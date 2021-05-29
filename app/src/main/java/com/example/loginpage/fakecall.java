package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class fakecall extends AppCompatActivity {
TextView fakecall;
    Button call5,call10,call15,call20;
    EditText calltext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fakecall);
        fakecall = (TextView) findViewById(R.id.fakecalltxt);
        call5 = (Button) findViewById(R.id.call5);
        call10 = (Button) findViewById(R.id.call10);
        call15 = (Button) findViewById(R.id.call15);
        call20 = (Button) findViewById(R.id.call20);
        calltext = (EditText) findViewById(R.id.callname);

        //5 second -- fake call module
        call5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountDownTimer countDownTimer=new CountDownTimer(5000,5000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        String str=calltext.getText().toString();
                        Intent i=new Intent(fakecall.this,callactivity.class);
                        i.putExtra("callersname",str);
                        startActivity(i);
                    }

                    @Override
                    public void onFinish() {
                        startActivity(new Intent(fakecall.this,fakecall.class));
                        Toast.makeText(fakecall.this,"5 sec Completed",Toast.LENGTH_SHORT).show();
                    }
                }.start();
            }
        });
//10 sec
        call10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountDownTimer countDownTimer=new CountDownTimer(10000,10000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        String str=calltext.getText().toString();
                        Intent i=new Intent(fakecall.this,callactivity.class);
                        i.putExtra("callersname",str);
                        startActivity(i);
                    }

                    @Override
                    public void onFinish() {
                        startActivity(new Intent(fakecall.this,fakecall.class));
                        Toast.makeText(fakecall.this,"10 sec Completed",Toast.LENGTH_SHORT).show();
                    }
                }.start();
            }
        });
        //15 sec
        call15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountDownTimer countDownTimer=new CountDownTimer(15000,15000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        String str=calltext.getText().toString();
                        Intent i=new Intent(fakecall.this,callactivity.class);
                        i.putExtra("callersname",str);
                        startActivity(i);
                    }

                    @Override
                    public void onFinish() {
                        startActivity(new Intent(fakecall.this,fakecall.class));
                        Toast.makeText(fakecall.this,"15 sec Completed",Toast.LENGTH_SHORT).show();
                    }
                }.start();
            }
        });
    //20 sec
        call20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountDownTimer countDownTimer=new CountDownTimer(20000,20000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        String str=calltext.getText().toString();
                        Intent i=new Intent(fakecall.this,callactivity.class);
                        i.putExtra("callersname",str);
                        startActivity(i);
                    }

                    @Override
                    public void onFinish() {
                        startActivity(new Intent(fakecall.this,fakecall.class));
                        Toast.makeText(fakecall.this,"20 sec Completed",Toast.LENGTH_SHORT).show();
                    }
                }.start();
            }
        });
    }
}