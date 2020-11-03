package ru.geekbrains.gb;

import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};

        //String[] words = {"apple", "orange"};

        makeWord(words);

    }

    public static void makeWord(String[] words) {

        Random rand = new Random(words.length - 1);

        String randomWord =  words[rand.nextInt(words.length)];

        Scanner sc = new Scanner(System.in); // создание объекта класса Scanner

        System.out.println("Отгадайте слово...");

        while (true) {

            System.out.println("Введите слово: ");

            String inputWord = sc.nextLine();

            if (inputWord.equals(randomWord)) {
                System.out.print("Вы угадали!");
                break;
            }

            boolean hasMatchingLetters = false;
            String matchingLetters = "";

            for (int i = 0; i < inputWord.length(); i++) {

                if (inputWord.charAt(i) == randomWord.charAt(i)) {
                    matchingLetters += inputWord.charAt(i);
                    hasMatchingLetters = true;
                }
                else {
                    matchingLetters += "*";
                }
            }

            for (int i = 15; inputWord.length() < i; i--) {
                matchingLetters += "*";
            }

            if (hasMatchingLetters) {
                System.out.println("Следующие буквы совпадают: " + matchingLetters);
            }
            else {
                System.out.println("Ни одна из букв не совпадает");
            }

        }

    }

}


