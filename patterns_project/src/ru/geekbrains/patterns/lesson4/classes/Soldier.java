package ru.geekbrains.patterns.lesson4.classes;

import ru.geekbrains.patterns.lesson4.interfaces.MilitaryUnit;

public class Soldier implements MilitaryUnit {
    private static final int DAMAGE = 5;
    private static final int DEFENCE = 5;

    @Override
    public int getDamage() {
        return DAMAGE;
    }

    @Override
    public int getDefense() {
        return DEFENCE;
    }
}
