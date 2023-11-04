package ua.nalezhytyi.hw9;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        Figure circle = new Circle(10);
        Triangle triangle = new Triangle(10, 10, 2);
        Figure square = new Square(50);

        displayCircleAreaAndPerimetr(circle);
        displaySquareAreaAndPerimetr(square);
        displayTriangleAreaAndPerimetr(triangle);


        Figure[] figures = {circle, triangle, square};
        displayFigureWithBiggestArea(figures);

    }

    private static void displayTriangleAreaAndPerimetr(Triangle triangle) {
        System.out.println("Perimeter and area of triangle: ");
        double area1 = ((Triangle) triangle).area();
        System.out.println("Area triangle using Herons formula :  " + area1);
        double area2 = ((Triangle) triangle).area(30);
        System.out.println("area of triangle using the product of two sides per sine angle:  " + area2);
        double area3 = ((Triangle) triangle).area(2, 2);
        System.out.println("area using a base height product:  " + area3);
        double trianglePerimetr = triangle.perimeter();
        System.out.println("perimetr triangle = " + trianglePerimetr);
        System.out.println();
    }

    private static void displayCircleAreaAndPerimetr(Figure figure) {
        System.out.println("Perimeter and area of circle: ");
        double circleArea = figure.area();
        System.out.println("Area circle : " + circleArea);
        double circlePerimetr = figure.perimeter();
        System.out.println("perimetr circle = " + circlePerimetr);
        System.out.println();
    }

    private static void displaySquareAreaAndPerimetr(Figure figure) {
        System.out.println("Perimeter and area of square: ");
        double squareArea = figure.area();
        System.out.println("Area square : " + squareArea);
        double squarePerimetr = figure.perimeter();
        System.out.println("Perimetr of square = " + squarePerimetr);
        System.out.println();
    }

    private static void displayFigureWithBiggestArea(Figure... figures) {
        Figure largestFigure = null;
        double largestArea = 0.0;

        for (Figure figure : figures) {
            double area;
            if (figure instanceof Triangle) {
                Triangle triangle = (Triangle) figure;
                area = triangle.area(30); // Визначте, який метод викликати для Triangle
            } else {
                area = figure.area(); // Викликаємо метод area для інших типів фігур
            }

            if (area > largestArea) {
                largestArea = area;
                largestFigure = figure;
            }
        }

        System.out.println("Figure with the biggest area : " + largestFigure);
    }
}
