package ru.geekbrains.gb;

import java.util.Random;
import java.util.Scanner;

public class App {

    public static int SIZE = 3;
    public static int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn(DOT_X);
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static boolean checkWin(char symb) {

        int symbCountHorizont;
        int symbCountVertical;
        int symbCountDiagonal1 = 0;
        int symbCountDiagonal2 = 0;

        for (int i = 0; i < SIZE; i++) {

            symbCountVertical = 0;
            symbCountHorizont = 0;

            for (int j = 0; j < SIZE; j++) {
                if (symb == map[i][j]) {
                    symbCountVertical++;
                }
                if (symbCountVertical == DOTS_TO_WIN) {
                    return true;
                }

                if(i == j && symb == map[i][j]) {
                    symbCountDiagonal1++;
                }

                if(i == (SIZE - 1 -j) && symb == map[i][j]) {
                    symbCountDiagonal2++;
                }

                if (symbCountDiagonal1 == DOTS_TO_WIN || symbCountDiagonal2 == DOTS_TO_WIN) {
                    return true;
                }
            }

            for (int j = 0; j < SIZE; j++) {
                if (symb == map[j][i]) {
                    symbCountHorizont++;
                }
                if (symbCountHorizont == DOTS_TO_WIN) {
                    return true;
                }
            }

        }

        return false;
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    public static void aiTurnRandom() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    public static void aiTurn(char opponentSymbol) {

        int symbCountHorizont;
        int symbCountVertical;
        int symbCountDiagonal1 = 0;
        int symbCountDiagonal2 = 0;

        for (int i = 0; i < SIZE; i++) {

            symbCountVertical = 0;
            symbCountHorizont = 0;

            for (int j = 0; j < SIZE; j++) {

                if (opponentSymbol == map[i][j]) {
                    symbCountVertical++;
                }

                if (i == j && opponentSymbol == map[i][j]) {
                    symbCountDiagonal1++;
                }

                if (i == (SIZE - 1 - j) && opponentSymbol == map[i][j]) {
                    symbCountDiagonal2++;
                }

                if (symbCountVertical == DOTS_TO_WIN - 1 && turnOnVertical(i)) {
                    return;
                }

                if (symbCountDiagonal1 == DOTS_TO_WIN - 1 && turnOnDiagonal(true)) {
                    return;
                }

                if (symbCountDiagonal2 == DOTS_TO_WIN - 1 && turnOnDiagonal(false)) {
                    return;
                }

            }

            for (int j = 0; j < SIZE; j++) {
                if (opponentSymbol == map[j][i]) {
                    symbCountHorizont++;
                }
                if (symbCountHorizont == DOTS_TO_WIN - 1 && turnOnHorizontal(j)) {
                    return;
                }
            }

        }

        aiTurnRandom();

    }

    public static boolean turnOnVertical(int rowOfMap){

        for (int i = 0; i < SIZE; i++) {
            if (map[rowOfMap][i] == DOT_EMPTY) {
                map[rowOfMap][i] = DOT_O;
                return true;
            }
        }
        return false;

    }

    public static boolean turnOnHorizontal(int colunmOfMap){

        for (int i = 0; i < SIZE; i++) {
            if (map[i][colunmOfMap] == DOT_EMPTY) {
                map[i][colunmOfMap] = DOT_O;
                return true;
            }
        }
        return false;

    }

    public static boolean turnOnDiagonal(boolean topDownDiagonal){

        for (int i = 0; i < SIZE; i++) {

            for (int j = 0; j < SIZE; j++) {

                if (topDownDiagonal && i == j && map[i][j] == DOT_EMPTY) {
                    map[i][j] = DOT_O;
                    return true;
                }

                if (topDownDiagonal && i == (SIZE - 1 - j) && map[i][SIZE - 1 - j] == DOT_EMPTY) {
                    map[i][SIZE - 1 - j] = DOT_O;
                    return true;
                }
            }
        }
        return false;
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y)); // while(isCellValid(x, y) == false)
        map[y][x] = DOT_X;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


}
