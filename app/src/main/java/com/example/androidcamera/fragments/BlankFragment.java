package com.example.androidcamera.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.leanback.app.BrowseSupportFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidcamera.MainActivity;
import com.example.androidcamera.R;

public class BlankFragment extends Fragment {
    TextView livepreview,addDevice,deviceMgr,chooseDevice;
    WebView webView;
    SharedPreferences sharedPref;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_blank, container, false);
        webView=view.findViewById(R.id.playback);
        sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        String Cam1URL = sharedPref.getString(getString(R.string.Cam1), "192.168.1.1");
        String Cam2URL = sharedPref.getString(getString(R.string.Cam2), "192.168.1.2");
        String Cam3URL = sharedPref.getString(getString(R.string.Cam3), "192.168.1.3");
        String Cam4URL = sharedPref.getString(getString(R.string.Cam4), "192.168.1.4");
        String Cam5URL = sharedPref.getString(getString(R.string.Cam5), "192.168.1.5");
        String Cam6URL = sharedPref.getString(getString(R.string.Cam6), "192.168.1.6");
        String Cam7URL = sharedPref.getString(getString(R.string.Cam7), "192.168.1.7");
        String Cam8URL = sharedPref.getString(getString(R.string.Cam8), "192.168.1.8");
        webView.loadUrl("ftp://" + Cam1URL);

        return view;
    }
}