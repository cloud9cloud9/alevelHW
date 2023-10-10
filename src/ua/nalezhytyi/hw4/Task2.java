package ua.nalezhytyi.hw4;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

// Заполнить одномерный массив случайными целочисленными значениями.
//• Проверить сколько простых чисел присутствует в массиве. Размер массива 1000 элементов.
public class Task2 {
    public static void main(String[] args) {
        int[] arrayOfNumbers = new int[1000];
        fill(arrayOfNumbers);
        System.out.println(Arrays.toString(arrayOfNumbers));
        System.out.println(integerNum(arrayOfNumbers));

    }
    public static void fill(int[] array) {
        for (int i = 0; i < array.length ; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(1, 10);
        }
    }
    public static int integerNum (int[] arr){
        int s = 0;
        for (int i = 0; i < arr.length ; i++) {
                if(isPrime(arr[i])) {
                    s++;
                }
            }
        return s;
    }
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
