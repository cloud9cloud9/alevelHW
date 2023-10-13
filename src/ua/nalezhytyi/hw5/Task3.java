package ua.nalezhytyi.hw5;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Task3 {
    //Дан двумерный массив NxN(количество строк = количество столбцов), написать программу
    //которая поменяет местами столбцы и строки.
    //*Необходимо создать новый массив, в котором выполняются превращения и вернуть его из метода.
    //Изначальный массив не должен измениться
    public static void main(String[] args) {
        int[][] firstArray = new int[4][4];
        fill(firstArray);
        System.out.println("Масив даних до заміни місцями строк і рядків: ");
        nextStr(firstArray);
        System.out.println();
        int[][] secondArr = swapRowsAndColumns(firstArray);
        System.out.println("Масив даних після заміни місцями строк і рядків: ");
        nextStr(secondArr);

    }

    public static void fill(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = ThreadLocalRandom.current().nextInt(1, 10);
            }
        }
    }

    public static void nextStr(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    public static int[][] swapRowsAndColumns(int[][] array) {
        int numRows = array.length;
        int numColumns = array[0].length;
        int[][] swappedArray = new int[numColumns][numRows];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                swappedArray[j][i] = array[i][j];
            }
        }
        return swappedArray;
    }
}
