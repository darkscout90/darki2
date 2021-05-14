package com.example.firstlesson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button yesBtn;
    private Button noBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        yesBtn = findViewById(R.id.butyes);
        noBtn = findViewById(R.id.butno);

        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,R.string.correct,Toast.LENGTH_SHORT).show(); //Глюк какой то, попробуем перезапустить студию
                yesBtn.setText(R.string.correct);
            }
        });
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,R.string.incorrect,Toast.LENGTH_SHORT).show();
                noBtn.setText(R.string.incorrect);

            }
        });
    }
}