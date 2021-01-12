package ru.geekbrains.patterns.lesson5.classes;

public abstract class QuestionSkeleton {
    protected QuestionSkeleton next;
    protected String question;

    public QuestionSkeleton setNext(QuestionSkeleton next) {
        this.next = next;
        return next;
    };

    public void handle() {};
}
