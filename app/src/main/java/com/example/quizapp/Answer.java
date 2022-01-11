package com.example.quizapp;

public class Answer {

    String ans;
    boolean isCorrect;

    Answer (String ans, boolean isCorrect) {
        this.ans = ans;
        this.isCorrect = isCorrect;
    }

    public String getAnswer() {return this.ans;}
    public boolean isAnswerCorrect() {return this.isCorrect;}

    public void setCorrectAns(boolean isCorrect) {this.isCorrect = isCorrect;}

}
