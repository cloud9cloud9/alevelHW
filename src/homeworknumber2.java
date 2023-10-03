public class homeworknumber2 {
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
        volume(x1, y1, x2, y2, x3, y3);

        // task 3
        int [] numbers1 = {1, 3, 5, 5, 6, 7,};
        int [] numbers2 = {1, 3, 5, 5, 6, 7};
        int max = numbersMax(numbers1);
        System.out.println("Найбілшим числом за модулем є : " + max);
        int min = numbersMin(numbers2);
        System.out.println("Найменшим числом за модулем є : " + min);

    }

    public static double volume(double a, double b, double c, double d, double e, double f) {
        double volume = 0.5 * Math.abs((a * (d - f) + c * (f - b) + e * (b - d)));
        // Area = 0.5 * |(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2))|
        System.out.println("Площа трикутника дорівнює: " + volume);

        // Task2
        if (volume % 2 == 0) {
            System.out.println("Площа трикутника є парним числом");
        } else {
            System.out.println("Площа трикутника є непарним числом ");
        }
        return volume;
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



