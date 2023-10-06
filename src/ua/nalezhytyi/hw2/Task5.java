package ua.nalezhytyi.hw2;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // отримуємо дані від користувача
        System.out.print("Введіть число:");
        String num = scan.next();
        // записуємо цифри в строку , розвертаємо число , яке отримали в зворотньому порядку
        String naobor = new StringBuilder(num).reverse().toString();
        // переводимо строку в числовий тип даних інт
        int revers = Integer.parseInt(naobor);
        // виводимо на екран монітору значення, яке отримали1
        System.out.println(naobor);
    }
}