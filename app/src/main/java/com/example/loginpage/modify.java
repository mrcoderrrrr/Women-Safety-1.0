package com.example.loginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class modify extends AppCompatActivity {
    TextView addtext,mname1,mphoneno1,memail1;
    EditText mname,mphoneno,memail;
    Button addcontacts;
    FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);
        addtext = (TextView) findViewById(R.id.addtext);
        mname1 = (TextView) findViewById(R.id.mname1);
        mphoneno1 = (TextView) findViewById(R.id.mphoneno1);
        memail1 = (TextView) findViewById(R.id.memail1);
        addcontacts = (Button) findViewById(R.id.addcontacts);
        mname = (EditText) findViewById(R.id.mname);
        mphoneno = (EditText) findViewById(R.id.mphoneno);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        memail = (EditText) findViewById(R.id.memail);
    getvaluefromuser();

    addcontacts.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String user_emails=memail.getText().toString();
        firebaseUser.updateEmail(user_emails).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(modify.this,"Modify Data",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(modify.this,"Can't Modify Data",Toast.LENGTH_SHORT).show();
                }
            }
        });
        }
    });
    }
            public void getvaluefromuser() {
                mname.getText().toString();
                mphoneno.getText().toString();
                memail.getText().toString();
            }
        }
