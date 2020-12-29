package ru.geekbrains.patterns.lesson3.factories;

import ru.geekbrains.patterns.lesson3.classes.WomenClothes;
import ru.geekbrains.patterns.lesson3.classes.WomenShoe;

public class WomenFactory implements WearFactory {
    public WomenShoe createShoe() {
        return new WomenShoe();
    }
    public WomenClothes createClothes() {
        return new WomenClothes();
    }
}
