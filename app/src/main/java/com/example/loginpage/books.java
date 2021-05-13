package com.example.loginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import static com.example.loginpage.R.id.about;
import static com.example.loginpage.R.id.feed;
import static com.example.loginpage.R.id.gesture;
import static com.example.loginpage.R.id.logoutfile;
import static com.example.loginpage.R.id.modify;

public class books extends AppCompatActivity {
    ImageView fakecall, scream, sendmsg, gps, emergency, chatbot;
    Intent intent;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        fakecall = (ImageView) findViewById(R.id.fakecall);
        scream = (ImageView) findViewById(R.id.scream);
        sendmsg = (ImageView) findViewById(R.id.sendmsg);
        gps = (ImageView) findViewById(R.id.gps);
        emergency = (ImageView) findViewById(R.id.emergancy);
        chatbot = (ImageView) findViewById(R.id.chatbot);
    firebaseAuth=FirebaseAuth.getInstance();
        setScream();
        setFakecall();
        setSendmsg();
        setGps();
        setEmergency();
    }
    //open fakecall activity -- Module page
    public void setFakecall()
    {
        fakecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(books.this,fakecall.class));
            }
        });
    }
    //Open screamsound activity -- Module page
    public void setScream()
    {
        scream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(books.this,screamsound.class));
            }
        });
    }
    //Open send message activity -- Module page
  public void setSendmsg(){
        sendmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(books.this, sendmsg.class));
            }
        });
    }
    //gpstracker activity -- Module page
    public void setGps() {
        gps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(books.this, gpstracker.class));
            }
        });
    }
    //emergancy number activity -- Module page
    public void setEmergency()
    {
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(books.this,emergancynumber.class));
            }
        });
    }
    //chatbot activity -- Module page
     public void setChatbot(){
        chatbot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(books.this,fakecall.class));
            }
        });
     }

    //menubar activity -- Module page
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menudata, menu);
        return true;
    }

    //Menubar logout - go to log in page (sign out your log in account) -- Module page
    public void logout() {
        firebaseAuth.signOut();
        Toast.makeText(this,"Log Out Sucessful",Toast.LENGTH_SHORT).show();
        finish();
    startActivity(new Intent(books.this,MainActivity.class));

    }


    //Menubar modify data -- Module page
    public void modifydata() {
        startActivity(new Intent(books.this,modify.class));
    }


    //Menubar feed -- Module page
    public void feed() {
        startActivity(new Intent(books.this,tipsfeed.class));
    }


    // Menubar about app -- Module page
    public void aboutapp() {
        startActivity(new Intent(books.this,aboutapp.class));
    }
    //Menubar smart gesture -- Module page
    public void gesture() {
        startActivity(new Intent(books.this,MainActivity.class));
    }

//menubar select particular option --  Module page
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        MenuInflater inflater=getMenuInflater();
        switch(item.getItemId()){
            case modify:
                modifydata();
                return true;
            case feed:
                feed();
                return true;
            case about:
                aboutapp();
                return true;
            case gesture:
                gesture();
                return true;
            case logoutfile:
                logout();
                return true;

        }return super.onOptionsItemSelected(item);
    }
}
