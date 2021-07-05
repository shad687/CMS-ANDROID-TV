package com.example.androidcamera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        sharedPref = getApplicationContext().getSharedPreferences("Reg",0);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

               Boolean loggedin= sharedPref.getBoolean("LoggedIn",false);
               if (loggedin==true)
               {
                   Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                   startActivity(intent);
                   finish();

               }
               else
               {
                   Intent intent = new Intent(SplashScreen.this,login.class);
                   startActivity(intent);
                   finish();
               }

                Intent intent = new Intent(SplashScreen.this, Register.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }
}