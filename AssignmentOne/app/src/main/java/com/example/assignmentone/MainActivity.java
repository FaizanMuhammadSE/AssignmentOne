package com.example.assignmentone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView screenView;//=findViewById(R.id.myView); //application was crashing, when I initialized it here
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> alphabets=new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        char value=65;
        for(int i=0;i<26;i++) {
            alphabets.add(String.valueOf((char)(value+i)));
        }
        arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,alphabets);
        screenView=findViewById(R.id.myView);
        screenView.setAdapter(arrayAdapter);
    }
}