package ru.geekbrains.gb;

public abstract class Animal {

    int swimmingLimit;
    int runningLimit;
    double jumpingLimit;

    public Animal(int swimmingLimit, int runningLimit, double jumpingLimit) {
        this.swimmingLimit = swimmingLimit;
        this.runningLimit = runningLimit;
        this.jumpingLimit = jumpingLimit;
    }

    void run(int actionMeasure) {
        if (actionMeasure <= runningLimit) {
            System.out.println("run: true");
        }
        else {
            System.out.println("run: false");
        }
    }

    void swim(int actionMeasure) {
        if (actionMeasure <= swimmingLimit) {
            System.out.println("swim: true");
        }
        else {
            System.out.println("swim: false");
        }
    }

    void jump(double actionMeasure) {
        if (actionMeasure <= jumpingLimit) {
            System.out.println("jump: true");
        }
        else {
            System.out.println("jump: false");
        }
    }

}
