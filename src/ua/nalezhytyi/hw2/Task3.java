package ua.nalezhytyi.hw2;

import java.util.Scanner;

// Определить является ли переданное в метод число четным или нет и вывести результат в
//консоль.
public class Task3 {
    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        int volume = scann.nextInt();
        boolean isOdd = isOdd(volume);
        if (isOdd) {
            System.out.println("Число є непарним");
        } else {
            System.out.println("Число є парним");
        }
    }
    public static boolean isOdd(int number){
        return number % 2 != 0;
    }
}
