package com.example.androidcamera;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.functions.FirebaseFunctions;
import com.google.firebase.functions.HttpsCallableResult;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Register extends AppCompatActivity {
    EditText email,password,name;
    Button submit;
    TextView login;
    FirebaseAuth mAuth;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    Calendar calendar;
    SimpleDateFormat simpledateformat,newDate;
    String Date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        submit=findViewById(R.id.submit);
        name = findViewById(R.id.name);
        sharedPref = getApplicationContext().getSharedPreferences("Reg",0);
        editor = sharedPref.edit();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference("users");

        Boolean loggedin=sharedPref.getBoolean("LoggedIn",false);
        if(loggedin==true)
        {
            startActivity(new Intent(Register.this,MainActivity.class));
            finish();
        }

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth = FirebaseAuth.getInstance();
                String emailTxt = email.getText().toString();
                String pwdText = password.getText().toString();
                if(!(emailTxt.isEmpty()) || !(pwdText.isEmpty()) || !(name.getText().toString().isEmpty()))
                {
                mAuth.createUserWithEmailAndPassword(emailTxt, pwdText)
                        .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                            .setDisplayName(name.getText().toString()).build();
                                    myRef.child(user.getUid()).setValue(NextDate());
                                    Intent intent=new Intent(Register.this,MainActivity.class);
                                    editor.putBoolean("LoggedIn",true);
                                    editor.commit();
                                    startActivity(intent);
                                    finish();

                                } else {
                                    Toast.makeText(Register.this,task.getException().toString(),
                                            Toast.LENGTH_SHORT).show();
                                }

                            }
                        });


            }
                else
                {
                    Toast.makeText(Register.this, "Please enter all details", Toast.LENGTH_SHORT).show();
                    getDate();}
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Register.this , login.class);
                startActivity(intent);
                Register.this.finish();
            }
        });


    }
    private String getDate() {
        calendar = Calendar.getInstance();
        simpledateformat = new SimpleDateFormat("dd-MM-yyyy");
        Date = simpledateformat.format(calendar.getTime());
        return Date;
    }
    private String NextDate()
    {
        String date = getDate();
        String year = date.substring(date.length()-4);
        int Nextyear =(Integer.parseInt(year) + 1);
        newDate=new SimpleDateFormat("dd-MM-");
        String nextDate = newDate.format(calendar.getTime());
        String CorrectDate=nextDate+Integer.toString(Nextyear);
        return CorrectDate;


    }

}