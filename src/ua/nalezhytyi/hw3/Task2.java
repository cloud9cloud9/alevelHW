package ua.nalezhytyi.hw3;

import java.util.Scanner;

// у мене баг в цій програмі, бо якщо ввести в кінці строки багато пробілів, то воно буде рахувати це як слова
// не знаю , як це виправити

//Подсчитать количество слов в строке
//• Вводится строка, состоящая из слов, разделенных пробелами. Требуется посчитать количество
//слов в ней.

public class Task2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String userInput = scanner(scan);
        userInput = customTrim(userInput);
        if (userInput.equals("")) {
            System.out.println("Ви ввели пусту строку.");
            } else {
                int wordCount = calcWordsInSentence(userInput, ' ');
                System.out.println("Кількість слів в реченні: " + wordCount);
        }
    }
    public static String scanner(Scanner s) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введіть ваше речення:");
        String sc = scan.nextLine();
        return sc;
    }
    public static int calcWordsInSentence(String text, char symbol) {
        int wordCounter = 1;
        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == symbol){
                wordCounter++;
            }
        }
        return wordCounter;
    }
    public static String customTrim(String input){
      return input.trim();
    }
}


