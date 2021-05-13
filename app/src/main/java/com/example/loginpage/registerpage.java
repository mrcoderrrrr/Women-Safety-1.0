package com.example.loginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class registerpage extends AppCompatActivity {
EditText name,emailids,phoneno,passwords;
TextView entername;
Button registerbtn;
TextView name2,phoneno2,emailid2,password2,register1;

    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);
        name=(EditText) findViewById(R.id.name);
       firebaseAuth=FirebaseAuth.getInstance();
        emailids=(EditText)findViewById(R.id.emailid);
        phoneno=(EditText)findViewById(R.id.phoneno);
        passwords=(EditText)findViewById(R.id.password);
        registerbtn=(Button)findViewById(R.id.registerbut);
        entername=(TextView)findViewById(R.id.enter_name);
        name2=(TextView)findViewById(R.id.name1);
        emailid2=(TextView)findViewById(R.id.emailid1);
        phoneno2=(TextView) findViewById(R.id.phoneno1);
        password2=(TextView) findViewById(R.id.password1);
    details();
    mainpage();
    login();
    check();
    }
    //fill details - get value form user  --- Register Page
    public void details(){
        name.getText().toString();
        emailids.getText().toString();
        phoneno.getText().toString();
        passwords.getText().toString();
    }
//After submit details go to log in page --- Register Page
    public void mainpage() {
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }
    //Enter Your Details and store in firebase ---Register page
        public void login() {
        if (check()) {
            String user_email = emailids.getText().toString();
            String user_password = passwords.getText().toString();
            firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(registerpage.this, "Details Submit", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(registerpage.this, books.class));
                    } else {
                        Toast.makeText(registerpage.this, "Login Failed", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

    }
    //If register form is empty show msg fill the form --Register page
    private boolean check(){
       boolean result=false;
        String fname=name.getText().toString();
        String phones=phoneno.getText().toString();
        String useremail = emailids.getText().toString();
        String userpassword = passwords.getText().toString();
        if(fname.isEmpty() ||  phones.isEmpty() || useremail.isEmpty() || userpassword.isEmpty() ){
            Toast.makeText(this,"Fill The Form",Toast.LENGTH_LONG).show();
        }
        else{
            result=true;
        }
        return result;
    }
 }