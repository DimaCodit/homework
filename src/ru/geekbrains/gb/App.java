package ru.geekbrains.gb;

public class App {

    public static void main(String[] args) {

        Dog tuzik = new Dog();

        tuzik.jump(1);

        Dog sharik  = new Dog();

        sharik.setJumpingLimit(1.5);
        sharik.jump(1);


    }

}
