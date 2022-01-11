package com.example.quizapp;

import java.util.Random;

public class Question {

    String question;
    Answer[] answers = new Answer[3];
    int isCorrect;
    Random ran = new Random();

    Question (String question, String[] answers, int isCorrect) {
        this.question = question;
        this.answers[0] = new Answer(answers[0], false);
        this.answers[1] = new Answer(answers[1], false);
        this.answers[2] = new Answer(answers[2], false);
        this.isCorrect = isCorrect;
        this.answers[isCorrect - 1].setCorrectAns(true);

        // Randomize answer selection using Fisher-Yates Shuffle Algorithm
        shuffleAnswers();
    }

    private void shuffleAnswers() {
        for(int i = this.answers.length - 1; i > 0; i--) {
            int index = ran.nextInt(i + 1);
            Answer temp = this.answers[index];
            this.answers[index] = this.answers[i];
            this.answers[i] = temp;
        }
    }

    public String getQuestion() {return this.question;}
    public Answer getAnswer1() {return this.answers[0];}
    public Answer getAnswer2() {return this.answers[1];}
    public Answer getAnswer3() {return this.answers[2];}

}
