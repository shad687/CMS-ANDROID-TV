package com.example.androidcamera.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.androidcamera.R;

import java.util.ArrayList;
import java.util.List;

public class AddDevice extends Fragment {
    Spinner spinner;
    EditText ip;
    Button button;
    String address,camNo;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_add_device, container, false);
       sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
       editor = sharedPref.edit();
        ;

        spinner=view.findViewById(R.id.spinner);
        ip=view.findViewById(R.id.ip);
        button=view.findViewById(R.id.button);
        List<String> list = new ArrayList<String>();
        list.add("Cam 1");
        list.add("Cam 2");
        list.add("Cam 3");
        list.add("Cam 4");
        list.add("Cam 5");
        list.add("Cam 6");
        list.add("Cam 7");
        list.add("Cam 8");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                camNo = spinner.getSelectedItem().toString();

                address=ip.getText().toString().trim();
                if (address.isEmpty())
                    Toast.makeText(getContext(), "Please Enter IP Address", Toast.LENGTH_SHORT).show();
                else {
                    editor.putString(camNo, address);
                    editor.commit();
                    Toast.makeText(getContext(), "Added", Toast.LENGTH_SHORT).show();
                }

                                            }
        });

        return view;
    }
}