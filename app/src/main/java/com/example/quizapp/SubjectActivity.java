package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SubjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
    }

    public void onAddSubClick(View v) {
        Intent intent = new Intent(this, AddSubActivity.class);
        startActivity(intent);
    }

    public void onMultiplyClick(View v) {
        Intent intent = new Intent(this, MultiplyActivity.class);
        startActivity(intent);
    }

}