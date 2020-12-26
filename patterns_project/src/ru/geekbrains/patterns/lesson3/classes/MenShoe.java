package ru.geekbrains.patterns.lesson3.classes;

import ru.geekbrains.patterns.lesson3.interfaces.Shoe;

public class MenShoe implements Shoe {
    public void getShoeName() {
        System.out.println("Мужские ботинки");
    }
}
