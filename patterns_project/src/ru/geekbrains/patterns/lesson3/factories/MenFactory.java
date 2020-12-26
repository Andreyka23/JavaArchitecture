package ru.geekbrains.patterns.lesson3.factories;

import ru.geekbrains.patterns.lesson3.classes.MenShoe;
import ru.geekbrains.patterns.lesson3.classes.MenClothes;

public class MenFactory implements WearFactory {
    public MenShoe createShoe() {
        return new MenShoe();
    }
    public MenClothes createClothes() {
        return new MenClothes();
    }
}
