package ru.geekbrains.patterns.lesson3.factories;

import ru.geekbrains.patterns.lesson3.interfaces.Clothes;
import ru.geekbrains.patterns.lesson3.interfaces.Shoe;

public interface WearFactory {
    Shoe createShoe();
    Clothes createClothes();
}
