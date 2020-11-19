package ru.geekbrains.gb;

public class App {

    public static void main(String[] args) {

        Dog tuzik = new Dog(10, 500, 0.5);

        tuzik.jump(1);

        Dog sharik  = new Dog(10, 500, 1);

        sharik.jumpingLimit = 1.5;
        sharik.jump(1);


    }

}
