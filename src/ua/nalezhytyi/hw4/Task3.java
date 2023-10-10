package ua.nalezhytyi.hw4;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

//Заполнить одномерный массив случайными целочисленными значениями.
//• Все четные значения заменить на нули. Размер массива - 2000 элементов.
public class Task3 {
    public static void main(String[] args) {
        int [] numbers = new int[2000];
        fill(numbers);
        System.out.println(Arrays.toString(numbers));
        replaceEvenWithZero(numbers);
        System.out.println(Arrays.toString(numbers));
    }
    public static void fill(int[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(1, 10);
        }
    }
    public static void replaceEvenWithZero(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                numbers[i] = 0;
            }
        }
    }
}
