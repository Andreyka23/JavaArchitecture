package ru.geekbrains.patterns.lesson3;

import ru.geekbrains.patterns.lesson3.factories.MenFactory;
import ru.geekbrains.patterns.lesson3.factories.WomenFactory;
import ru.geekbrains.patterns.lesson3.factories.WearFactory;

import java.util.Scanner;

public class Main {

    // Абстрактная фабрика
    public static void main(String[] args) {
        System.out.println("Выберите для кого костюм: m - мужчина, w - женщина.");
        Scanner scanner = new Scanner(System.in);
        String choose = scanner.nextLine();
        while (!(choose.equals("m") || choose.equals("w"))) {
            System.out.println("Ошибка выбора.");
            choose = scanner.nextLine();
        }
        WearFactory wearFactory;
        if (choose.equals("m")) {
            wearFactory = new MenFactory();
        } else {
            wearFactory = new WomenFactory();
        }
        Service service = new Service(wearFactory);
        service.getCostume();

    }

}
