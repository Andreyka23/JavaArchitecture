package ru.geekbrains.patterns.lesson3;

import ru.geekbrains.patterns.lesson3.factories.WearFactory;

public class Service {
    private WearFactory wearFactory;

    public Service (WearFactory wearFactory) {
        this.wearFactory = wearFactory;
    }

    public void getCostume() {
        this.wearFactory.createShoe().getShoeName();
        this.wearFactory.createClothes().getClothesName();
    }

}
