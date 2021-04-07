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


        int imageStore1[]={R.drawable.a1,R.drawable.b1,R.drawable.c1,R.drawable.d1,R.drawable.e1,R.drawable.f1,R.drawable.g1,R.drawable.h1,R.drawable.i1,R.drawable.j1,R.drawable.k1,R.drawable.l1,R.drawable.m1,R.drawable.n1,R.drawable.o1,R.drawable.p1,R.drawable.q1,R.drawable.r1,R.drawable.s1,R.drawable.t1,R.drawable.u1,R.drawable.v1,R.drawable.w1,R.drawable.x1,R.drawable.y1,R.drawable.z1};
        int imageStore2[]={R.drawable.a2,R.drawable.b2,R.drawable.c2,R.drawable.d2,R.drawable.e2,R.drawable.f2,R.drawable.g2,R.drawable.h2,R.drawable.i2,R.drawable.j2,R.drawable.k2,R.drawable.l2,R.drawable.m2,R.drawable.n2,R.drawable.o2,R.drawable.p2,R.drawable.q2,R.drawable.r2,R.drawable.s2,R.drawable.t2,R.drawable.u2,R.drawable.v2,R.drawable.w2,R.drawable.x2,R.drawable.y2,R.drawable.z2};
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