package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddSubActivity extends AppCompatActivity {

    public static final String EXTRA_TOPIC = "com.example.quizapp.TOPIC_ADDSUB";
    public static final String EXTRA_SUBTOPIC = "com.example.quizapp.SUBTOPIC_ADDSUB";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sub);
    }

    public void onAddSubClick(View v) {
        Intent intent = new Intent(this, QuizActivity.class);
        Button addSubButton = (Button) v;
        String subtopic = addSubButton.getText().toString();
        intent.putExtra(EXTRA_TOPIC, "AddSub");
        intent.putExtra(EXTRA_SUBTOPIC, subtopic);
        startActivity(intent);
    }

}