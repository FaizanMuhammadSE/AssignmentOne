package com.example.assignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class LessonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);


        int imageStore1[]={R.drawable.a1,R.drawable.b1};
        int imageStore2[]={R.drawable.a2,R.drawable.b2};
        Intent intent=getIntent();
        TextView textView=findViewById(R.id.lessonName);
        String character=intent.getStringExtra("alphabet");
        textView.setText(character);

        ImageView img1=findViewById(R.id.imageView1);
        ImageView img2=findViewById(R.id.imageView2);
        img1.setImageDrawable(getResources().getDrawable(imageStore1[character.charAt(0)-'A']));
        img2.setImageDrawable(getResources().getDrawable(imageStore2[character.charAt(0)-'A']));
    }
}