package ru.geekbrains.gb;

public class App {

    public static void main(String[] args) {

        Cat[] cats = new Cat[5];

        cats[0] = new Cat("Барсик", 5);
        cats[1] = new Cat("Себастьян", 10);
        cats[2] = new Cat("Моцарт", 30);
        cats[3] = new Cat("Филипп", 15);
        cats[4] = new Cat("Джек", 50);

        Plate plate = new Plate(100);

        plate.info();

        for (Cat cat : cats) {

            cat.eat(plate);

            if (cat.isFullness()) {
                System.out.println("Кот " + cat.getName() + " наелся");
            }
            else {
                System.out.println("Кот " + cat.getName() + " остался голоден");
            }

        }

        plate.info();

    }

}
