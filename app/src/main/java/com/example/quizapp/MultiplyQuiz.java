package com.example.quizapp;

import java.util.Random;

public class MultiplyQuiz extends Quiz{

    Random r = new Random();

    MultiplyQuiz(int numOfQuestions, String subtopic) {
        super(numOfQuestions, subtopic);
    }

    @Override
    public void generateQuestions() {
        int first, second, rightAns, ans1, ans2;
        int ansRange = 10;
        String question;

        second = Integer.parseInt(this.subtopic.substring(2));

        while (this.questions.size() < this.numOfQuestions) {
            first = r.nextInt(12) + 1;
            rightAns = first * second;
            question = first + " x " + second;
            ans1 = r.nextInt(ansRange) + rightAns + 1;
            ans2 = r.nextInt(ansRange) + rightAns - ansRange;
            if(ans2 < 0) {ans2 = rightAns + 1;}

            this.questions.push(new Question(question,
                    new String[]{String.valueOf(rightAns), String.valueOf(ans1), String.valueOf(ans2)},
                    1));

        }

    }
}
