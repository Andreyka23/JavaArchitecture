package ru.geekbrains.patterns.lesson3.classes;

import ru.geekbrains.patterns.lesson3.interfaces.Clothes;

public class MenClothes implements Clothes {
    public void getClothesName() {
        System.out.println("Мужской костюм.");
    }
}
