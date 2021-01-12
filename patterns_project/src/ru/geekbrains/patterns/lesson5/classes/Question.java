package ru.geekbrains.patterns.lesson5.classes;

import java.util.Scanner;

public class Question extends QuestionSkeleton {

    public Question(String question) {
        this.question = question;
    }

    @Override
    public void handle() {
        System.out.println(question);
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        while (answer.isEmpty()) {
            System.out.println("Пустой ответ. Введите еще раз.");
            answer = scanner.nextLine();
        }
        System.out.println("Ответ:" + answer);
        if (next != null)
            next.handle();
        else
            System.out.println("Спасибо за ответы! Анкета завершена.");

    }
}
