package ru.geekbrains.patterns.lesson4.classes;

import ru.geekbrains.patterns.lesson4.interfaces.MilitaryUnit;

import java.util.ArrayList;
import java.util.List;

public class Army implements MilitaryUnit {

    protected List<MilitaryUnit> units = new ArrayList<>();

    public void add(MilitaryUnit unit) {
        units.add(unit);
    }

    public void remove(String className) {
        for (int i = 0; i < units.size(); i++) {
            if (units.get(i).getClass().getName().equals(className)) {
                units.remove(i);
            }
        }
    }

    @Override
    public int getDamage() {
        int totalDamage = 0;
        for (int i = 0; i < units.size(); i++) {
            totalDamage += units.get(i).getDamage();
        }
        return totalDamage;
    }

    @Override
    public int getDefense() {
        int totalDefense = 0;
        for (int i = 0; i < units.size(); i++) {
            totalDefense += units.get(i).getDefense();
        }
        return totalDefense;
    }
}
