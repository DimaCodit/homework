package ru.geekbrains.gb;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int n) {

        if (n > food) {
            food = 0;
        }
        else {
            food -= n;
        }
    }

    public void addFood(int moreFood) {
        food += moreFood;
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}