package ua.nalezhytyi.hw2;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Task4 {
    public static void main(String[] args) {
        int[] arrayModule = new int[3];
        fillArray(arrayModule);
        System.out.println(Arrays.toString(arrayModule));
        int result = minusAndSmallestIntInModule(arrayModule);
        System.out.println(result);
    }

    public static int minusAndSmallestIntInModule(int[] array) {
        int minAbsoluteValue = Math.abs(array[0]);
        int minValueInArr = 0;
        for (int i = 0; i < array.length; i++) {
            int result = (array[i] < 0) ? Math.abs(array[i]) : array[i];
            if (minAbsoluteValue > result){
                minAbsoluteValue = result;
                minValueInArr = i;
            }
        }
        if (array[minValueInArr] < 0) {
            return array[minValueInArr];
        } else {
            return minAbsoluteValue;
        }
    }

    public static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(-50, 50);
        }
    }
}
