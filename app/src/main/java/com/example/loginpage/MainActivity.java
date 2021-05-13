package com.example.loginpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.text.style.DrawableMarginSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    EditText username, password;
    FirebaseAuth firebaseAuth;
    TextView logintext, description, username1, password1, forget, register, newaccount, newaccount1;
    Intent intent, intent2;
    Button loginbut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logintext = (TextView) findViewById(R.id.logintext);
        description = (TextView) findViewById(R.id.description);
        username1 = (TextView) findViewById(R.id.username1);
        password1 = (TextView) findViewById(R.id.password1);
        forget = (TextView) findViewById(R.id.forget);
        register = (TextView) findViewById(R.id.registerbut);
        newaccount = (TextView) findViewById(R.id.newaccount);
        newaccount1 = (TextView) findViewById(R.id.newaccount1);
        loginbut = (Button) findViewById(R.id.loginbut);
        username = (EditText) findViewById(R.id.username);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        //if user is note null then open module activity
        if (user != null) {
            finish();
            startActivity(new Intent(MainActivity.this, books.class));
        }
        password = (EditText) findViewById(R.id.password);
//after click on log in button verify the details and go to modules page --- log in page
        loginbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check(username.getText().toString(),password.getText().toString());

            }
        });
        register();
forgotpassword();
//intent means go from one activity to another activity ---- log in
        intent = new Intent(getApplicationContext(), books.class);
        intent2 = new Intent(getApplicationContext(), registerpage.class);
    }



//firebase authentication is use to verify details store in firebase --- Log in page
    public void check(String usernames, String passwords) {
        firebaseAuth.signInWithEmailAndPassword(usernames, passwords).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
if(task.isSuccessful()){
    Toast.makeText(MainActivity.this,"Log in Sucessful",Toast.LENGTH_LONG).show();
    startActivity(intent);
}
else {
    Toast.makeText(MainActivity.this,"Try again",Toast.LENGTH_LONG).show();
}
            }
        });
    }

//forogt password to reset the password ---log in page
public void forgotpassword(){
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText emailtxt=new EditText(v.getContext());
                //alert dialog box
                AlertDialog.Builder forgotemail=new AlertDialog.Builder(v.getContext());
                forgotemail.setTitle("Forgot Password");
                forgotemail.setMessage("Enter your registratored Email ID to sent you password reset instructions");
                forgotemail.setMessage("Enter Email Address :");
                forgotemail.setView(emailtxt);
                //positive button (send)
                forgotemail.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String email = emailtxt.getText().toString().trim();
                        firebaseAuth.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                            Toast.makeText(MainActivity.this,"Reset Password Link Sent On Your Mail Id",Toast.LENGTH_SHORT).show();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(MainActivity.this, "Error"+e.getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        });


                    }
                    //negative button(cancel)
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                forgotemail.create().show();
            }

        });
    }
    //Open register form   --- Log in Page
            public void register() {
                newaccount1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(intent2);
                    }
                });
            }
        }