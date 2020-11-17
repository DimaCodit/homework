package ru.geekbrains.gb;

public class Cat {

    private String name;
    private int appetite;
    private boolean fullness;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        fullness = false;
    }

    public String getName() {
        return name;
    }

    public boolean isFullness() {
        return fullness;
    }

    public void eat(Plate plate) {

        if (plate.getFood() >= appetite) {
            plate.decreaseFood(appetite);
            fullness = true;
        }

    }
}
