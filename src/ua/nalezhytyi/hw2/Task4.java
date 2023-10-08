package ua.nalezhytyi.hw2;

public class Task4 {
    public static void main(String[] args) {
        int [] numbers1 = {1, 3, 5, 5, 6, 7,};
        int [] numbers2 = {1, 3, 5, 5, 6, 7};
        int max = numbersMax(numbers1);
        System.out.println("Найбілшим числом за модулем є : " + max);
        int min = numbersMin(numbers2);
        System.out.println("Найменшим числом за модулем є : " + min);

    }
    public static int numbersMax(int[] numbers1) {
        int max = numbers1[0];
        for (int i = 0; i < numbers1.length; i++) {
            if(numbers1[i] > max) {
                max = numbers1[i];
            }
        }
        return max;
    }

    public static int numbersMin(int[] numbers2) {
        int min = numbers2[0];
        for (int i = 0; i <numbers2.length ; i++) {
            if(numbers2[i] < min) {
                min = numbers2[i];
            }
        }
        return min;
    }
}
