package ru.geekbrains.patterns.lesson4;

import ru.geekbrains.patterns.lesson4.classes.Army;
import ru.geekbrains.patterns.lesson4.classes.General;
import ru.geekbrains.patterns.lesson4.classes.Soldier;

public class Main {

    // Компоновщик
    public static void main(String[] args) {
        Soldier soldier = new Soldier();
        General general = new General();
        Army army = new Army();
        Army army2 = new Army();
        army.add(soldier);
        army.add(general);
        army2.add(general);
        army.add(army2);
        System.out.println("Damage: " + army.getDamage());
        System.out.println("Defense: " + army.getDefense());

        army.remove(general.getClass().getName());
        System.out.println(army.getDamage());

        army.remove(army2.getClass().getName());
        System.out.println(army.getDamage());


    }
}
