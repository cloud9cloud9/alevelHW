package ua.nalezhytyi.hw5;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Task1 {
    //Заполнение двумерного массива значениями индекса (от 1 и до кол-ва элементов в
    //массиве), при этом каждая вторая строка - отрицательными значениями.
    //Например
    //1 2 3
    //-4 -5 -6
    //7 8 9
    //-10 -11 -12
    //*Передать массив в метод, заполнить данный массив
    public static void main(String[] args) {
        int[][] arr = new int[5][5];
        fillArray(arr);
        System.out.println("Масив, числа в якому змінені на мінусові " + Arrays.deepToString(arr));

    }


    public static void fillArray(int[][] array) {
        int arr = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i % 2 ==0) {
                    array[i][j] = arr ++;
                } else {
                    array[i][j] = -arr++;
                }
            }
        }
    }
}
