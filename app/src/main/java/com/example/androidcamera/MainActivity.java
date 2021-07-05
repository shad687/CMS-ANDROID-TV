package com.example.androidcamera;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidcamera.fragments.AddDevice;
import com.example.androidcamera.fragments.VideoViews;
import com.example.androidcamera.fragments.chooseStorage;
import com.example.androidcamera.fragments.deviceManager;
import com.example.androidcamera.fragments.livepreview;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    WebView webView,webView2;
    Button livepreview,addDevice,deviceMgr,logout;
    ListView listView;
    Calendar calendar;
    SimpleDateFormat simpledateformat,newDate;
    DatabaseReference myRef;
    FirebaseDatabase database;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    String Date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        livepreview=findViewById(R.id.livePreview);
        addDevice=findViewById(R.id.AddDevice);
        deviceMgr=findViewById(R.id.deviceManager);
        logout=findViewById(R.id.logout);



        deviceMgr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.mainframe,new deviceManager()).commit();
                deviceMgr.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                deviceMgr.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                livepreview.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                livepreview.setTextColor(getResources().getColor(R.color.colorPrimary));
                addDevice.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                addDevice.setTextColor(getResources().getColor(R.color.colorPrimary));


            }
        });
        livepreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.mainframe,new livepreview()).commit();
                Toast.makeText(MainActivity.this, "Viewing Live Previews", Toast.LENGTH_SHORT).show();

                livepreview.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                livepreview.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                addDevice.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                addDevice.setTextColor(getResources().getColor(R.color.colorPrimary));
                deviceMgr.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                deviceMgr.setTextColor(getResources().getColor(R.color.colorPrimary));

            }
        });
        addDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.mainframe,new AddDevice()).commit();
                Toast.makeText(MainActivity.this, "Adding A Device", Toast.LENGTH_SHORT).show();
                addDevice.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                addDevice.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                livepreview.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                livepreview.setTextColor(getResources().getColor(R.color.colorPrimary));
                deviceMgr.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                deviceMgr.setTextColor(getResources().getColor(R.color.colorPrimary));


            }
        });


        getSupportFragmentManager().beginTransaction().replace(R.id.mainframe,new livepreview()).commit();
        livepreview.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        livepreview.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        getDate();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("users").child(user.getUid());
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                simpledateformat = new SimpleDateFormat("dd-mm-yyyy");
                java.util.Date Date1 = null;
                java.util.Date Date2 = null;
                try {
                    Date1 = simpledateformat.parse(getDate());
                    Date2 = simpledateformat.parse(value);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                if (Date1.compareTo(Date2) == 0 || (Date1.after(Date2))) {
                    Log.i("MainActivty",Date1.toString()+Date2.toString());
                    Toast.makeText(MainActivity.this, Date1.toString()+Date2.toString(), Toast.LENGTH_SHORT).show();
                    Log.i("MainActivty",Date1.toString()+Date2.toString());
                    startActivity(new Intent(MainActivity.this, licence.class));
                    finish();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                sharedPref = getApplicationContext().getSharedPreferences("Reg",0);
                editor = sharedPref.edit();
                editor.putBoolean("LoggedIn",false).commit();
                startActivity(new Intent(MainActivity.this,login.class));

                finish();
            }
        });
    }
    private String getDate() {
        calendar = Calendar.getInstance();
        simpledateformat = new SimpleDateFormat("dd-mm-yyyy");
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