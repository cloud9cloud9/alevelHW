package ua.nalezhytyi.hw3;

import java.util.Scanner;

// Удалить из строки пробелы и определить, является ли она перевертышем (палиндромом)
public class Task1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String userInput = scanner(scan);
        String replacedsc = replaceSpace(userInput);
        System.out.println(replacedsc);

        String replaced = turnOver(replacedsc);
        System.out.println(replaced);

        boolean result = isTrue(replacedsc, replaced);
        if(result == true){
            System.out.println("Ваше речення є поліндромом(перевертнем)");
        } else{
            System.out.println("Ваше речення не є поліндромом(перевертнем)");
        }

    }
    //  Удалить из строки пробелы и определить
    public static String replaceSpace(String input){
        String replaced = input.replace(" ", "");
            return replaced;
    }
    // является ли она перевертышем (палиндромом)
    public static String turnOver(String turn) {
        StringBuilder reverse1 = new StringBuilder(turn);
        return reverse1.reverse().toString();
    }
    // метод , що зчитує данні користувача
    public static String scanner(Scanner s){
        Scanner scan = new Scanner(System.in);
        System.out.print("Введіть ваше речення:");
        String sc = scan.nextLine();
        return sc;
    }
    // метод, який визначає, чи є наше речення поліндромом
    public static boolean isTrue (String dontReplace, String replace){
       return dontReplace == replace;
    }
}
