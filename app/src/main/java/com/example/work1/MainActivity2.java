package com.example.work1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        int a = intent.getIntExtra("bbb",1);
        TextView textView = findViewById(R.id.TextView_user);
        textView.setText("这是第"+(a+1)+"个用户");
    }
}