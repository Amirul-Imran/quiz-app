package com.example.quizapp;

import java.util.EmptyStackException;
import java.util.Stack;

abstract class Quiz {

    Stack<Question> questions = new Stack<>();
    int numOfQuestions;
    String subtopic;

    Quiz (int numOfQuestions, String subtopic) {
        this.numOfQuestions = numOfQuestions;
        this.subtopic = subtopic;
    }

    public abstract void generateQuestions();

    public Question nextQuestion() throws EmptyStackException {
        if(!questions.empty()) {
            return questions.pop();
        }

        throw new EmptyStackException();
    }

}
