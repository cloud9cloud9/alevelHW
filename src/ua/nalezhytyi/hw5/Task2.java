package ua.nalezhytyi.hw5;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Task2 {
    //Проверить, заданный массив на упорядоченность по убыванию, т. е. определить, верно ли,
    //что каждый его элемент, начиная со второго, не больше предыдущего.
    //*передать массив в метод, получить boolean
    public static void main(String[] args) {
        int[] arrays = new int[25];
        fillArray(arrays);
        boolean is = isNumDecrease(arrays);
        System.out.println(Arrays.toString(arrays));
        if (is) {
            System.out.println("Ваш масив даних є таким, числа якого постійно зменшуються ");
        } else {
            System.out.println("Ваш масив даних є таким, числа якого нерівномірні, тобто наступне число більше за попереднє ");
        }
        fill(arrays);
        is = isNumDecrease(arrays);
        System.out.println(Arrays.toString(arrays));
        if (is) {
            System.out.println("Ваш масив даних є таким, числа якого постійно зменшуються ");
        } else {
            System.out.println("Ваш масив даних є таким, числа якого нерівномірні, тобто наступне число більше за попереднє ");
        }

    }

    public static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(1, 25);
        }
    }

    public static boolean isNumDecrease(int[] array) {
        boolean isEverNextNum = false;
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
                isEverNextNum = true;
            } else {
                isEverNextNum = false;
            }
        }
        return isEverNextNum;
    }

    public static void fill(int[] array) {
        int forArr = 25;
        for (int i = 0; i < array.length; i++) {
            array[i] = forArr;
            forArr--;
        }
    }
}
