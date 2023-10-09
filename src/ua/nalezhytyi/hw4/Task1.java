package ua.nalezhytyi.hw4;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

//Заполнить одномерный массив случайными целочисленными значениями.
//• Найти среднее арифметическое и среднее геометрическое элементов массива. Размер массива -
//400 элементов.
//P.S. значения элементов можно ограничить значениями 1-10 включительно.
public class Task1 {
    public static void main(String[] args) {
        int [] numbers = new int[400];
        fill(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println("Середнє арифметичне: " + ariphmeticMean(numbers));
        System.out.println("Середнє геометричне: : " + geometricMean(numbers));
    }
    public static void fill(int[] array) {
        for (int i = 0; i <array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(1 , 10);
        }
    }
    // середнє арифметичне
    public static double ariphmeticMean (int[] array){
        double sum = 0;
        for (int i = 0; i < array.length ; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }

    // середнє геометричне
    public static double geometricMean(int[] array) {
        double sum = 1;
        for (int i = 0; i < array.length; i++) {
            sum *= array[i];
        }
        return Math.sqrt(sum);
    }
}
