package ua.nalezhytyi.hw11;

import java.util.Arrays;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(3);
        array.add(1);
        array.add(2);
        array.add(3);
        System.out.println(Arrays.toString(array.get()));
        array.add(4, 1);
        array.add(3, 0);
        array.add(2, 2);
        System.out.println(Arrays.toString(array.get()));
        System.out.println("index of this value : " + array.indexOf(2));
        System.out.println("is contains elements in array: " + array.isContains(10));

        Integer getValue = array.get(1); // Отримуємо значення за індексом 1
        System.out.println("value by this index : " + getValue);

        System.out.println("without removed value of arrays: " + Arrays.toString(array.get()));
        System.out.println("with removed value of arrays: " + array.remove(2) + " and new array : " + Arrays.toString(array.get()));

    }
}

