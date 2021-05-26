package com.example.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public String str="";
    private Button yesBtn;
    private Button noBtn;
    private Button showAnswer;
    private TextView textView;
    private Question[] questions = new Question[]{
            new Question(R.string.question0,true),
            new Question(R.string.question1,false),
            new Question(R.string.question2,false),
            new Question(R.string.question3,false),
            new Question(R.string.question4,false),
            new Question(R.string.question5, true)
    };
    private int questionIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("SYSTEM INFO: ", "Метод onCreate() запущен");

        if(savedInstanceState != null){
            questionIndex = savedInstanceState.getInt("questionIndex");
        }

        yesBtn = findViewById(R.id.btnYes);
        noBtn = findViewById(R.id.btnNo);
        textView = findViewById(R.id.textView);
        showAnswer = findViewById(R.id.showAnswer);
        textView.setText(questions[questionIndex].getQuestionResId());
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questions[questionIndex].isAnswerTrue()){
                    Toast.makeText(MainActivity.this,R.string.correct,Toast.LENGTH_SHORT).show();
                    str +=getString(questions[questionIndex].getQuestionResId()) +"Ответ:"+getString(R.string.correct)+"\n";
                }

                else{
                    Toast.makeText(MainActivity.this,R.string.incorrect,Toast.LENGTH_SHORT).show();
                    str +=getString(questions[questionIndex].getQuestionResId()) +" Ответ:"+getString(R.string.incorrect)+"\n";
                }





                questionIndex = (questionIndex+1)%questions.length;
                textView.setText(questions[questionIndex].getQuestionResId());
                if (questionIndex==questions.length-1){
                   Intent intent = new Intent(MainActivity.this,Itogi.class);
                   intent.putExtra("key1",str);
                   startActivity(intent);
                }
            }
        });
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questions[questionIndex].isAnswerTrue()){
                    Toast.makeText(MainActivity.this,R.string.incorrect,Toast.LENGTH_SHORT).show();
                    str +=getString(questions[questionIndex].getQuestionResId()) +" Ответ:"+getString(R.string.incorrect)+"\n";
                }

                else{
                    Toast.makeText(MainActivity.this,R.string.correct,Toast.LENGTH_SHORT).show();
                    str +=getString(questions[questionIndex].getQuestionResId()) +"Ответ:"+getString(R.string.correct)+"\n";

                }


                questionIndex = (questionIndex+1)%questions.length;
                textView.setText(questions[questionIndex].getQuestionResId());
                if (questionIndex==questions.length-1){
                    Intent intent = new Intent(MainActivity.this,Itogi.class);
                    intent.putExtra("key1",str);
                    startActivity(intent);
                }
            }
        });
        showAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnswerActivity.class);
                intent.putExtra("answer",questions[questionIndex].isAnswerTrue());
                startActivity(intent);
            }
        });
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d("SYSTEM INFO: ", "Метод onStart() запущен");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d("SYSTEM INFO: ", "Метод onResume() запущен");
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.d("SYSTEM INFO: ", "Метод onSaveInstanceState() запущен");
        savedInstanceState.putInt("questionIndex",questionIndex);
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d("SYSTEM INFO: ", "Метод onPause() запущен");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d("SYSTEM INFO: ", "Метод onStop() запущен");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("SYSTEM INFO: ", "Метод onDestroy() запущен");
    }
}