package com.example.assignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        int videoLessons[]={R.raw.a,R.raw.b,R.raw.c};
        videoView=findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+videoLessons[(int)getIntent().getStringExtra("alphabet").charAt(0)-'A']);
        MediaController mediaController=new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        videoView.pause();
    }
}