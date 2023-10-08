package ua.nalezhytyi.hw2;

public class Task2 {
    public static void main(String[] args) {
        /* у написанні методу, який шукає найбільше і найменше число в модулі, використав допомогу chatgpt
        бо в моєму методі, який я сам написав, чомусь не виводились данні, писало просто що немає помилок в
        коді, і все
        public static int numbers(int[] numbers1) {
        int min = numbers1[0];
        int max = numbers1[0];
        for (int i = 0; i < numbers1.length; i++) {
            if (numbers1[i] > max) {
                max = numbers1[i];
            }
        }
        return max; - це те, що я написав

        int [] numbers1 = {1, 3, 5, 5, 6, 7,};
        int max = numbers(numbers1);
        System.out.println(max); - це те, що мені порадив написати chatgpt у методі main
         */
/*
     використав double для точності результату , при використанні int видає помилку
 */
        double x1 = 1.0;
        double y1 = 5.0;
        double x2 = 3.0;
        double y2 = 5.0;
        double x3 = 6.0;
        double y3 = 7.0;
        // Calculating the Area of a Triangle Using Cartesian Coordinates
        volume1(x1, y1, x2, y2, x3, y3);
    }
    public static double volume1(double a, double b, double c, double d, double e, double f) {
        double volume = 0.5 * Math.abs((a * (d - f) + c * (f - b) + e * (b - d)));
        // Area = 0.5 * |(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2))|
        System.out.println("Площа трикутника дорівнює: " + volume);
        return volume;
    }
}



