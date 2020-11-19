package ru.geekbrains.gb;

public class Cat extends Animal{

    public Cat(int swimmingLimit, int runningLimit, double jumpingLimit) {
        super(0, runningLimit, jumpingLimit);
    }

    @Override
    void swim(int actionMeasure) {
        System.out.println("cat do not can swim");
    }
}
