package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MultiplyActivity extends AppCompatActivity {

    public static final String EXTRA_TOPIC = "com.example.quizapp.TOPIC_MULTIPLY";
    public static final String EXTRA_SUBTOPIC = "com.example.quizapp.SUBTOPIC_MULTIPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiply);
    }

    public void onMultiplyClick(View v) {
        Intent intent = new Intent(this, QuizActivity.class);
        Button multiplyButton = (Button) v;
        String subtopic = multiplyButton.getText().toString();
        intent.putExtra(EXTRA_TOPIC, "Multiply");
        intent.putExtra(EXTRA_SUBTOPIC, subtopic);
        startActivity(intent);
    }

}