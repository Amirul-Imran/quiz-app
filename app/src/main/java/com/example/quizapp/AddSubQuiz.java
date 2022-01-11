package com.example.quizapp;

import java.util.Random;

public class AddSubQuiz extends Quiz{

    char[] operators = {'+', '-'};
    Random r = new Random();

    AddSubQuiz(int numOfQuestions, String subtopic) {
        super(numOfQuestions, subtopic);
    }

    @Override
    public void generateQuestions() {

        int digits = Integer.parseInt(this.subtopic.substring(0, 1));
        int tens = (int) Math.pow(10, digits - 1);
        int ansRange = 5 * tens;
        int first, second, rightAns, ans1, ans2;
        String question;

        while(this.questions.size() < this.numOfQuestions) {
            char operand = operators[r.nextInt(2)];
            first = r.nextInt(5 * tens) + (5 * tens);
            second = r.nextInt(first - tens + 1) + tens;

            if(operand == '+') {
                rightAns = first + second;
                question = first + " + " + second;
            }
            else {
                rightAns = first - second;
                question = first + " - " + second;
            }

            ans1 = r.nextInt(ansRange) + rightAns + 1;
            ans2 = r.nextInt(ansRange) + rightAns - ansRange;
            if(ans2 < 0) {ans2 = rightAns + 1;}

            this.questions.push(new Question(question,
                    new String[]{String.valueOf(rightAns), String.valueOf(ans1), String.valueOf(ans2)},
                    1));

        }

    }
}
