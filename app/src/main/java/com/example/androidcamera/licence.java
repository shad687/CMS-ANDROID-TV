package com.example.androidcamera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class licence extends AppCompatActivity {
    Button button;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_licence);

        button=findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(licence.this,login.class));
                FirebaseAuth.getInstance().signOut();
                sharedPref = getApplicationContext().getSharedPreferences("Reg",0);
                editor = sharedPref.edit();
                editor.putBoolean("LoggedIn",false).commit();
                finish();
            }
        });

    }
}