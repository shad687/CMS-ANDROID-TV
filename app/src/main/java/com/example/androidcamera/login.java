package com.example.androidcamera;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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

public class login extends AppCompatActivity {
    EditText email,password;
    Button submit;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    TextView register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        submit=findViewById(R.id.submit);
        register=findViewById(R.id.login);
        sharedPref = getApplicationContext().getSharedPreferences("Reg",0);
        editor = sharedPref.edit();
        Boolean loggedin=sharedPref.getBoolean("LoggedIn",false);
        if(loggedin==true)
        {
            startActivity(new Intent(login.this,MainActivity.class));
            finish();
        }
        final FirebaseAuth auth = FirebaseAuth.getInstance();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailTxt = email.getText().toString();
                String pwdTxt = password.getText().toString();

                if (!emailTxt.isEmpty() || !pwdTxt.isEmpty()) {

                    auth.signInWithEmailAndPassword(emailTxt, pwdTxt).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(login.this, MainActivity.class);
                                editor.putBoolean("LoggedIn",true);
                                editor.commit();
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(login.this, "Authentication Error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }
                else {
                    Toast.makeText(login.this, "Please Enter All Details", Toast.LENGTH_SHORT).show();

                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this , Register.class);
                startActivity(intent);
                finish();
            }
        });
    }
}