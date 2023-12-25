package ua.nalezhytyi.hw13;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main program = new Main();
        program.run();
        System.out.println("Figures with area twice greater than perimetr is " +
                withAreaTwiceGreaterThanPerimeter(initializeListOfFigures()));

    }

    private void run() {
        double difference = 16;
        Figure resultFigure = findFigure(difference);
        System.out.println("Difference is: " + difference);

        if (resultFigure != null) {
            System.out.println("figure with sum difference to smallest area of figure:  " + resultFigure);
        } else {
            System.out.println("Фігура не знайдена.");
        }
    }

    private Figure findFigure(double difference) {
        List<Figure> listOfFigures = initializeListOfFigures();
        Figure smallestFigure = listOfFigures.stream()
                .min(Comparator.comparingDouble(Figure::area))
                .orElse(null);
        System.out.println("The smallest figure is : " + smallestFigure);

        if (smallestFigure != null) {
            double newArea = smallestFigure.area() + difference;
            return listOfFigures.stream()
                    .filter(figure -> figure.area() == newArea)
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    private static Figure withAreaTwiceGreaterThanPerimeter(List<Figure> list) {
        list = initializeListOfFigures();
        return list.stream()
                .filter(figure -> figure.area() == figure.perimeter() * 2)
                .findFirst()
                .orElse(null);
    }
    private static List<Figure> initializeListOfFigures() {
        return Arrays.asList(new Square(5.0), new Square(7.0), new Square(10.0), new Square(3.0),
                new Square(4.0), new Square(8.0));
    }
}
