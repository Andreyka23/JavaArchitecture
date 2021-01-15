package ru.geekbrains.patterns.lesson5;

import ru.geekbrains.patterns.lesson5.classes.Question;
import ru.geekbrains.patterns.lesson5.classes.QuestionSkeleton;

public class Main {

    // Chain of Responsibility 
    public static void main(String[] args) {
        System.out.println("Заполнете анкету:");
        QuestionSkeleton question = new Question("Ваше имя?");
        question.setNext(new Question("Сколько лет?"))
                .setNext(new Question("Откуда вы?"));

        question.handle();
    }

}
