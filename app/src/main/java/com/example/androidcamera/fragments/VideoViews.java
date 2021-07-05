package com.example.androidcamera.fragments;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.androidcamera.R;

public class VideoViews extends Fragment {
    VideoView vw1,vw2,vw3,vw4,vw5,vw6,vw7,vw8;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_views, container, false);
        vw1 = view.findViewById(R.id.vw1);
        vw2 = view.findViewById(R.id.vw2);
        vw3 = view.findViewById(R.id.vw3);
        vw4 = view.findViewById(R.id.vw4);
        vw5 = view.findViewById(R.id.vw5);
        vw6 = view.findViewById(R.id.vw6);
        vw7 = view.findViewById(R.id.vw7);
        vw8 = view.findViewById(R.id.vw8);
        MediaController mediaController = new MediaController(getContext());
        mediaController.setAnchorView(vw1);
        mediaController.setMediaPlayer(vw2);
        Uri video = Uri.parse("rtsp://184.72.239.149/vod/mp4:BigBuckBunny_175k.mov");
        vw1.setMediaController(mediaController);
        vw1.setVideoURI(video);
        vw1.start();

        return view;
    }
}