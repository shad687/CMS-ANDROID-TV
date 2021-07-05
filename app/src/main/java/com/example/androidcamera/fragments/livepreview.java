package com.example.androidcamera.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.androidcamera.R;

public class livepreview extends Fragment {
    WebView webView1,webView2,webView3,webView4,webView5,webView6,webView7,webView8;
    SharedPreferences sharedPref;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_livepreview, container, false);
        sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        String Cam1URL = sharedPref.getString(getString(R.string.Cam1), "192.168.1.1");
        String Cam2URL = sharedPref.getString(getString(R.string.Cam2), "192.168.1.2");
        String Cam3URL = sharedPref.getString(getString(R.string.Cam3), "192.168.1.3");
        String Cam4URL = sharedPref.getString(getString(R.string.Cam4), "192.168.1.4");
        String Cam5URL = sharedPref.getString(getString(R.string.Cam5), "192.168.1.5");
        String Cam6URL = sharedPref.getString(getString(R.string.Cam6), "192.168.1.6");
        String Cam7URL = sharedPref.getString(getString(R.string.Cam7), "192.168.1.7");
        String Cam8URL = sharedPref.getString(getString(R.string.Cam8), "192.168.1.8");
        String Cam1Scale = sharedPref.getString(getString(R.string.Cam1Scale), "100");
        String Cam2Scale = sharedPref.getString(getString(R.string.Cam2Scale), "100");
        String Cam3Scale = sharedPref.getString(getString(R.string.Cam3Scale), "100");
        String Cam4Scale = sharedPref.getString(getString(R.string.Cam4Scale), "100");
        String Cam5Scale = sharedPref.getString(getString(R.string.Cam5Scale), "100");
        String Cam6Scale = sharedPref.getString(getString(R.string.Cam6Scale), "100");
        String Cam7Scale = sharedPref.getString(getString(R.string.Cam7Scale), "100");
        String Cam8Scale = sharedPref.getString(getString(R.string.Cam8Scale), "100");


        webView1 = view.findViewById(R.id.cam1);
        webView1.getSettings().setJavaScriptEnabled(true);
        webView1.getSettings().setBuiltInZoomControls(true);
        webView1.getSettings().setAllowFileAccess(true);
        webView1.setSoundEffectsEnabled(true);
        webView1.setWebViewClient(new WebViewClient());

        webView1.loadUrl("http://" + Cam1URL);
        try {
        webView1.setInitialScale(Integer.parseInt(Cam1Scale));
        }
       catch(NumberFormatException nfe) {
           webView1.setInitialScale(100);
        }
        webView1.setOverScrollMode(View.OVER_SCROLL_ALWAYS);
        webView1.getSettings().setAppCachePath(getContext().getFilesDir().getAbsolutePath()+"/cache");
        webView1.getSettings().setDatabasePath(getContext().getFilesDir().getAbsolutePath()+"/databases");
        webView1.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                webView1.loadUrl("https://www.iconfinder.com/data/icons/tech-support-4/30/add_camera-512.png");

            }
        });

        //Webview2
        webView2=view.findViewById(R.id.cam2);
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.getSettings().setBuiltInZoomControls(true);
        webView2.getSettings().setAllowFileAccess(true);
        webView2 .setSoundEffectsEnabled(true);
        webView2.setWebViewClient(new WebViewClient());
        webView2.loadUrl("http://"+Cam2URL);
        try {
            webView2.setInitialScale(Integer.parseInt(Cam2Scale));
        }
        catch(NumberFormatException nfe) {
            webView2.setInitialScale(100);
        }
        webView2.setOverScrollMode(View.OVER_SCROLL_ALWAYS);
        webView2.getSettings().setAppCachePath(getContext().getFilesDir().getAbsolutePath()+"/cache");
        webView2.getSettings().setDatabasePath(getContext().getFilesDir().getAbsolutePath()+"/databases");
        webView2.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                webView2.loadUrl("https://www.iconfinder.com/data/icons/tech-support-4/30/add_camera-512.png");

            }
        });


        //Webview 3
        webView3=view.findViewById(R.id.cam3);
        webView3.getSettings().setJavaScriptEnabled(true);
        webView3.getSettings().setBuiltInZoomControls(true);
        webView3.getSettings().setAllowFileAccess(true);
        webView3 .setSoundEffectsEnabled(true);
        webView3.setWebViewClient(new WebViewClient());
        webView3.loadUrl("http://"+Cam3URL);
        try {
            webView3.setInitialScale(Integer.parseInt(Cam3Scale));
        }
        catch(NumberFormatException nfe) {
            webView3.setInitialScale(100);
        }
        webView3.getSettings().setAppCachePath(getContext().getFilesDir().getAbsolutePath()+"/cache");
        webView3.getSettings().setDatabasePath(getContext().getFilesDir().getAbsolutePath()+"/databases");
        webView3.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                webView3.loadUrl("https://www.iconfinder.com/data/icons/tech-support-4/30/add_camera-512.png");

            }
        });

        //Webview 4
        webView4=view.findViewById(R.id.cam4);
        webView4.getSettings().setJavaScriptEnabled(true);
        webView4.getSettings().setBuiltInZoomControls(true);
        webView4.getSettings().setAllowFileAccess(true);
        webView4 .setSoundEffectsEnabled(true);
        webView4.setWebViewClient(new WebViewClient());
        webView4.loadUrl("http://"+Cam4URL);
        try {
            webView4.setInitialScale(Integer.parseInt(Cam4Scale));
        }
        catch(NumberFormatException nfe) {
            webView4.setInitialScale(100);
        }
        webView4.getSettings().setAppCachePath(getContext().getFilesDir().getAbsolutePath()+"/cache");
        webView4.getSettings().setDatabasePath(getContext().getFilesDir().getAbsolutePath()+"/databases");
        webView4.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                webView4.loadUrl("https://www.iconfinder.com/data/icons/tech-support-4/30/add_camera-512.png");

            }
        });

        //Webview 5
        webView5=view.findViewById(R.id.cam5);
        webView5.getSettings().setJavaScriptEnabled(true);
        webView5.getSettings().setBuiltInZoomControls(true);
        webView5.getSettings().setAllowFileAccess(true);
        webView5 .setSoundEffectsEnabled(true);
        webView5.setWebViewClient(new WebViewClient());
        webView5.loadUrl("http://"+Cam5URL);
        try {
            webView5.setInitialScale(Integer.parseInt(Cam5Scale));
        }
        catch(NumberFormatException nfe) {
            webView5.setInitialScale(100);
        }
        webView5.getSettings().setAppCachePath(getContext().getFilesDir().getAbsolutePath()+"/cache");
        webView5.getSettings().setDatabasePath(getContext().getFilesDir().getAbsolutePath()+"/databases");
        webView5.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                webView5.loadUrl("https://www.iconfinder.com/data/icons/tech-support-4/30/add_camera-512.png");

            }
        });

        //Webview 6
        webView6=view.findViewById(R.id.cam6);
        webView6.getSettings().setJavaScriptEnabled(true);
        webView6.getSettings().setBuiltInZoomControls(true);
        webView6.getSettings().setAllowFileAccess(true);
        webView6 .setSoundEffectsEnabled(true);
        webView6.setWebViewClient(new WebViewClient());
        webView6.loadUrl("http://"+Cam6URL);
        try {
            webView6.setInitialScale(Integer.parseInt(Cam6Scale));
        }
        catch(NumberFormatException nfe) {
            webView6.setInitialScale(100);
        }
        webView6.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                webView6.loadUrl("https://www.iconfinder.com/data/icons/tech-support-4/30/add_camera-512.png");

            }
        });

        //Webview 7
        webView7=view.findViewById(R.id.cam7);
        webView7.getSettings().setJavaScriptEnabled(true);
        webView7.getSettings().setBuiltInZoomControls(true);
        webView7.getSettings().setAllowFileAccess(true);
        webView7 .setSoundEffectsEnabled(true);
        webView7.setWebViewClient(new WebViewClient());
        webView7.loadUrl("http://"+Cam7URL);
        try {
            webView7.setInitialScale(Integer.parseInt(Cam7Scale));
        }
        catch(NumberFormatException nfe) {
            webView7.setInitialScale(100);
        }
        webView7.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                webView7.loadUrl("https://www.iconfinder.com/data/icons/tech-support-4/30/add_camera-512.png");

            }
        });

        //Webview 8
        webView8=view.findViewById(R.id.cam8);
        webView8.getSettings().setJavaScriptEnabled(true);
        webView8.getSettings().setBuiltInZoomControls(true);
        webView8.getSettings().setAllowFileAccess(true);
        webView8 .setSoundEffectsEnabled(true);
        webView8.setWebViewClient(new WebViewClient());
        webView8.loadUrl("http://"+Cam8URL);
        try {
            webView8.setInitialScale(Integer.parseInt(Cam8Scale));
        }
        catch(NumberFormatException nfe) {
            webView8.setInitialScale(100);
        }
        webView8.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                webView8.loadUrl("https://www.iconfinder.com/data/icons/tech-support-4/30/add_camera-512.png");

            }
        });



        return view;
    }

}