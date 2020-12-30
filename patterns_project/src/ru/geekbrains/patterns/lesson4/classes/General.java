package ru.geekbrains.patterns.lesson4.classes;

import ru.geekbrains.patterns.lesson4.interfaces.MilitaryUnit;

public class General implements MilitaryUnit {
    private static final int DAMAGE = 10;
    private static final int DEFENCE = 10;

    @Override
    public int getDamage() {
        return DAMAGE;
    }

    @Override
    public int getDefense() {
        return DEFENCE;
    }
}
