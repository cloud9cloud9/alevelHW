package ua.nalezhytyi.hw4;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

//Заполнить одномерный массив случайными целочисленными значениями.
//• Все четные значения заменить на нули. Размер массива - 2000 элементов.
public class Task3 {
    public static void main(String[] args) {
        int [] numbers = new int[2000];
        fill(numbers);
        int[] arrayCopies = replaceEvenWithZero(numbers);
        System.out.println(Arrays.toString(numbers));
        replaceEvenWithZero(arrayCopies);
        System.out.println(Arrays.toString(arrayCopies));
    }
    public static void fill(int[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(1, 10);
        }
    }
    public static int[] replaceEvenWithZero(int[] numbers) {
        int[] numbersCopies = Arrays.copyOf(numbers, numbers.length);
        for (int i = 0; i < numbersCopies.length; i++) {
            if (numbersCopies[i] % 2 == 0) {
                numbersCopies[i] = 0;
            }
        }
        return numbersCopies;
    }
}
