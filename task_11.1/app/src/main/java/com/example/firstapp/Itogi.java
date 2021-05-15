package com.example.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Itogi extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itogi);
        textView = findViewById(R.id.textView2);
        Bundle arguments = getIntent().getExtras();
        String str2 = arguments.get("key1").toString();
        textView.setText(str2);

    }
}