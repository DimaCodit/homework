package ru.geekbrains.gb;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        //{ Задание 1
        int[] arr = { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };

        for (int i = 0; i < arr.length; i++) {
            if (arr[i]== 1)
                arr[i] = 0;
            else if (arr[i]== 0)
                arr[i] = 1;
        }

        System.out.println(Arrays.toString(arr));
        //}

        //{ Задание 2
        int[] arrayForFilling = new int[8];

        for (int i = 0; i < 8; i++) {
            arrayForFilling[i] = i * 3;
        }

        System.out.println(Arrays.toString(arrayForFilling));

        //}

        //{ Задание 3

        int[] arrayForChange = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };

        for (int i = 0; i < arrayForChange.length; i++) {
            if (arrayForChange[i] < 6)
                arrayForChange[i] *= 6;

        }

        System.out.println(Arrays.toString(arrayForChange));
        //}

        //{ Задание 4
        int[][] arrayTwoDimensional = new int[7][7];

        for (int i = 0; i < arrayTwoDimensional.length; i++) {

            for (int j = 0; j < arrayTwoDimensional[i].length; j++) {

                if (j == i || j == (arrayTwoDimensional[i].length - 1 - i))
                    arrayTwoDimensional[i][j] = 1;

            }

        }

        for (int[] ints : arrayTwoDimensional) {
            System.out.println(Arrays.toString(ints));
        }
        //}

        //{ Задание 5
        int[] arrayForMinMax = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1, 0};

        int minValue = arrayForMinMax[0];
        int maxValue = arrayForMinMax[0];

        for (int i = 1; i < arrayForMinMax.length; i++) {

            if (arrayForMinMax[i] < minValue)
                minValue = arrayForMinMax[i];
            if (arrayForMinMax[i] > maxValue)
                maxValue = arrayForMinMax[i];
        }

        System.out.println("min: " + minValue);
        System.out.println("max: " + maxValue);
        //}

        //{ Задание 6, проверка
        System.out.println(checkBalance(new int[]{2, 2, 2, 1, 2, 2, 10, 1}));
        System.out.println(checkBalance(new int[]{2, 2, 2, 1, 2, 2, 10, 2}));
        //}

        //{ Задание 7, проверка
        int [] ArrayShiftResult = toShiftArray(new int[] { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 }, 4);
        System.out.println(Arrays.toString(ArrayShiftResult));
        //}

    }

    //{ Задание 6

    public static boolean checkBalance(int[] array) {

        boolean result = false;

        int sumStart = array[0];
        int sumEnd;

        for (int i = 1; i < array.length; i++) {

            sumStart += array[i];
            sumEnd = array[array.length-1];

            for (int j = array.length - 2; j > i; j--) {
                sumEnd += array[j];
            }

            if (sumStart == sumEnd) {
                return true;
            }

        }

        return false;

    }

    //}

    //{ Задание 7

    public static int[] toShiftArray(int[] arrayForShift, int numberForShift) {

        //Так как в заданиии не указано в какую сторону смещать элементы, то смещаю в лево.

        numberForShift = Math.abs(numberForShift);

        //Если число для смещения больше размера массива, то ничего не делаю.

        if (Math.abs(numberForShift) > arrayForShift.length) {
            return arrayForShift;
        }

        for (int i = 0; i < arrayForShift.length; i++) {

            if (i + numberForShift < arrayForShift.length) {
                arrayForShift[i] = arrayForShift[i + numberForShift];
            }
            else {
                arrayForShift[i] = 0;

            }

        }

        return arrayForShift;

    }

    //}

}


