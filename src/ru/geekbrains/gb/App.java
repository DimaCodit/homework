package ru.geekbrains.gb;

public class App {

    public static void main(String[] args) {
        byte first = 1;
        short second = 33;
        int third = 19999;
        long noname = 444444;

        float fifth = 5.5f;
        double sixth = 0.5;

        char seventh = 'H';

        boolean eighth = true;

        int result1 = calculate3(1, 5, 4, 8);
        System.out.println(result1);

        boolean result2 = verify4(1, 5);
        System.out.println(result2);

        positive5(-3);

        boolean result3 = verify6(-1);
        System.out.println(result3);

        hello7("Gomer");

        boolean result4 = leapYear8(2000);
        System.out.println(result4);

    }

    public static int calculate3(int a, int b, int c, int d) {
        return a * (b + (c / d));
    }

    public static boolean verify4(int a, int b) {
        int sum = a+b;
        if ( sum >= 10 || sum <= 20)
            return true;
        else
            return false;

    }

    public static void positive5(int a) {
        if( a >= 0)
            System.out.println("Число положителное");
        else
            System.out.println("Число отрицательное");
    }

    public static boolean verify6(int a) {
        if( a < 0)
            return true;
        else
            return false;
    }

    public static void hello7(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public static boolean leapYear8(int year) {
        if (year%400 == 0)
            return true;
        else if(year%100 == 0)
            return false;
        else if (year%4 == 0)
            return true;
        else
            return false;
    }

}
