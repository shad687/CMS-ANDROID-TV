package com.example.androidcamera.fragments;

import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.androidcamera.R;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import static android.content.Context.USB_SERVICE;

public class chooseStorage extends Fragment {
    boolean isAvailable= false;
    boolean isWritable= false;
    boolean isReadable= false;
    Spinner spinner;
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view =inflater.inflate(R.layout.fragment_choose_storage, container, false);
        File[] externalStorageFiles= ContextCompat.getExternalFilesDirs(getContext(),null);
        String state = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(state)){
        // Read and write operation possible
            isAvailable= true;
            isWritable= true;
            isReadable= true;
        } else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)){
            // Read operation possible
            isAvailable= true;
            isWritable= false;
            isReadable= true;
        } else {
            // SD card not mounted
            isAvailable = false;
            isWritable= false;
            isReadable= false; }
        spinner=view.findViewById(R.id.storageType);
        button=view.findViewById(R.id.button2);
        List<String> list = new ArrayList<String>();
        list.add("Cam 1");
        list.add("Cam 2");
        list.add("Cam 3");
        list.add("Cam 4");
        list.add("Cam 5");
        list.add("Cam 6");
        list.add("Cam 7");
        list.add("Cam 8");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                String storage= spinner.getSelectedItem().toString();
                Uri selectedUri = Uri.parse(Environment.getExternalStorageDirectory()+"");
                if (storage.equals("Internal Storage"))
                    selectedUri = Uri.parse("/storage/emulated/0/");
                else
                    selectedUri = Uri.parse("/storage/");
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setDataAndType(selectedUri, "resource/folder");
                if (intent.resolveActivityInfo(getContext().getPackageManager(), 0) != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(getContext(), "File Manager Not Available", Toast.LENGTH_SHORT).show();
                }
                Intent intent  = new Intent(Settings.ACTION_INTERNAL_STORAGE_SETTINGS);
                startActivityForResult(intent, 0);      */
            getFragmentManager().beginTransaction().replace(R.id.mainframe,new BlankFragment()).commit();}
        });
                 ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, list);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
               spinner.setAdapter(dataAdapter);
                return view;
    }


}