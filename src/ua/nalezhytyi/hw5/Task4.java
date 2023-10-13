package ua.nalezhytyi.hw5;

import java.util.Random;
import java.util.Arrays;

public class Task4 {
    //Удаление из массива k-го элемента со сдвигом всех расположенных справа от него
    //элементов на одну позицию влево.
    //*Необходимо создать новый массив, в котором удаляется элемент и вернуть его из метода.
    //Изначальный массив не должен измениться
    //[1, 2, 3, 4] -> [1, 2, 4]
    public static void main(String[] args) {
        int[] array = new int [10]; //створення масиву
        fill(array);
        int[] arrayToChange = removeItem(array, 4);
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(arrayToChange));

    }
    // цей метод допоміг написат chatgpt, сорі(
    public static int[] removeItem(int[] numbers, int index) {
    int[] result = new int[numbers.length - 1];
    for (int i = 0, j = 0; i < numbers.length; i++) {
        if (i == index) {
            continue; // Пропускаємо елемент, який ми хочемо видалити.
        }
        result[j++] = numbers[i]; // ось цей елемент коду не розумію, що він робитть?
    }
    return result;
}
    public static void fill(int[] array){
        int forArr = 1;
        for (int i = 0; i < array.length; i++) {
            array[i] = forArr;
            forArr++;
        }
    }
}
