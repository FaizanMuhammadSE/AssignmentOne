package com.example.assignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.material.button.MaterialButtonToggleGroup;

import java.sql.Time;

public class ImageShow extends AppCompatActivity {


    //just declare variables there, dont initialize them with views data, coz activity starts from onCreate method
    int getImages[]={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,R.drawable.h,R.drawable.i,R.drawable.j,R.drawable.k,R.drawable.l,R.drawable.m,R.drawable.n,R.drawable.o,R.drawable.p,R.drawable.q,R.drawable.r,R.drawable.s,R.drawable.t,R.drawable.u,R.drawable.v,R.drawable.w,R.drawable.x,R.drawable.y,R.drawable.z};
    double start[]={8, 21.5, 31,39};
    double end[]={21.5, 31, 38,48};
    char alphabet;
    MediaPlayer mp;
    ImageView im;
    Button soundBtn;
    Button animationBtn;
    Button videoBtn;
    Button lessonBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_show);

        soundBtn=findViewById(R.id.button);
        animationBtn=findViewById(R.id.animationButton);
        videoBtn=findViewById(R.id.videoButton);
        lessonBtn=findViewById(R.id.lessonButton);

        Intent intent=getIntent();
        mp=MediaPlayer.create(this,R.raw.song);
        //make sound buttons disabled

        //animationBtn.setEnabled(false);
        //soundBtn.setEnabled(false);
        im=findViewById(R.id.alphabets);
        alphabet=intent.getStringExtra("ClickedAlphabet").charAt(0);
        im.setImageDrawable(getResources().getDrawable(getImages[alphabet-'A']));
    }




    public void playSound(View view) {

        //soundBtn.setEnabled(false);
        //animationBtn.setEnabled(false);
        //videoBtn.setEnabled(false);
        //lessonBtn.setEnabled(false);
        //mp=MediaPlayer.create(this,R.raw.song);
        //if(mp.isPlaying())
        mp.reset();
        mp=MediaPlayer.create(this,R.raw.song);
        mp.seekTo((int) start[alphabet-'A']*1000);
        mp.start();

        //while(mp.isPlaying())
        //{
        //    if(mp.getCurrentPosition()>=end[alphabet-'A']*1000) {
        //        mp.stop();
        //        break;
        //    }
        //}
        //now sound is over, so enabled all buttons
        //soundBtn.setEnabled(true);
        //animationBtn.setEnabled(true);
        //videoBtn.setEnabled(true);
        //lessonBtn.setEnabled(true);
    }

    public void playAnimation(View view) {

        animationBtn.setEnabled(false);
        im.animate().rotation(360*2).alpha((float) 0.3).setDuration(3000).withEndAction(new Runnable() {
            @Override
            public void run() {
                im.animate().rotation(360).alpha(1).setDuration(7000).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        //after animation ends, sound button enabled
                        //soundBtn.setEnabled(true);
                        animationBtn.setEnabled(true);
                    }
                });
            }
        });
    }


    public void playLesson(View view){

    }

    public void playVideo(View view){

    }


    @Override
    protected void onPause() {            //stop when another activity start, or this activity destroy
        super.onPause();
        if(mp.isPlaying())              //stop media when we are moving to another activity
            mp.stop();
    }

    public void pauseSound(View view) {
        if(mp.isPlaying())
            mp.pause();
    }
}