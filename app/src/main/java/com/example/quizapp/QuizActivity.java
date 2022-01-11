package com.example.quizapp;

import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    int questionNo = 1, highscore = 0, numOfQuestions = 10;
    TextView outcome, question, answer1, answer2, answer3, score;
    Button endQuizButton;
    String topic, subtopic;
    Quiz quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Intent intent = getIntent();
        if(intent.hasExtra(AddSubActivity.EXTRA_TOPIC)) {
            topic = intent.getStringExtra(AddSubActivity.EXTRA_TOPIC);
            subtopic = intent.getStringExtra(AddSubActivity.EXTRA_SUBTOPIC);
            quiz = new AddSubQuiz(numOfQuestions, subtopic);
        }
        else {
            topic = intent.getStringExtra(MultiplyActivity.EXTRA_TOPIC);
            subtopic = intent.getStringExtra(MultiplyActivity.EXTRA_SUBTOPIC);
            quiz = new MultiplyQuiz(numOfQuestions, subtopic);
        }

        quiz.generateQuestions();

        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        question = findViewById(R.id.question);
        outcome = findViewById(R.id.outcome);
        score = findViewById(R.id.score);
        endQuizButton = findViewById(R.id.endQuizButton);

        setQuestion();

    }

    private void setQuestion() {

        Question q = quiz.nextQuestion();

        question.setText(q.getQuestion());
        answer1.setText(q.getAnswer1().getAnswer());
        answer1.setTag("");
        answer2.setText(q.getAnswer2().getAnswer());
        answer2.setTag("");
        answer3.setText(q.getAnswer3().getAnswer());
        answer3.setTag("");

        if(q.getAnswer1().isAnswerCorrect()) {
            answer1.setTag("Correct");
        }
        else if(q.getAnswer2().isAnswerCorrect()) {
            answer2.setTag("Correct");
        }
        else if(q.getAnswer3().isAnswerCorrect()) {
            answer3.setTag("Correct");
        }

    }

    public void onAnswerClick(View v) {
        TextView answer = (TextView) v;
        ColorStateList original = answer.getTextColors();
        Handler handler = new Handler();

        questionNo++;

        answer1.setEnabled(false);
        answer2.setEnabled(false);
        answer3.setEnabled(false);

        if(v.getTag() == "Correct") {
            outcome.setText("Well Done!");
            answer.setTextColor(GREEN);
            highscore++;
        }
        else {
            answer.setTextColor(RED);
            if(answer1.getTag() == "Correct") {
                answer1.setTextColor(GREEN);
                outcome.setText("Try Again! Right answer is " + answer1.getText().toString());
            }
            else if(answer2.getTag() == "Correct") {
                answer2.setTextColor(GREEN);
                outcome.setText("Try Again! Right answer is " + answer2.getText().toString());
            }
            else if(answer3.getTag() == "Correct") {
                answer3.setTextColor(GREEN);
                outcome.setText("Try Again! Right answer is " + answer3.getText().toString());
            }
        }

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                outcome.setText("");
                answer1.setTextColor(original);
                answer2.setTextColor(original);
                answer3.setTextColor(original);
                answer1.setEnabled(true);
                answer2.setEnabled(true);
                answer3.setEnabled(true);

                if(questionNo <= numOfQuestions) {
                    setQuestion();
                }
                else {
                    question.setText("");
                    answer1.setText("");
                    answer2.setText("");
                    answer3.setText("");
                    score.setText("You scored " + highscore + "/" + numOfQuestions + "!");
                    endQuizButton.setVisibility(View.VISIBLE);
                }
            }
        }, 2500);

    }

    public void onEndClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
