package ua.nalezhytyi.hw9;

import java.util.Scanner;

import static ua.nalezhytyi.hw9.Triangle.area;

public class Main {
    public static void main(String[] args) {
        Figure circle = new Circle(10);
        Triangle triangle = new Triangle(8, 10, 6);
        Figure square = new Square(50);

        displayCircleAreaAndPerimetr(circle);
        displaySquareAreaAndPerimetr(square);
        displayTriangleAreaAndPerimetr(triangle);

        Figure[] figures = {circle, triangle, square};
        displayFigureWithBiggestArea(figures);

        System.out.println("New homework :");
        Figure circle2 = new Circle();
        Figure square2 = new Square();
        Figure triangle2 = new Triangle();

        double areaCircle = calculateCircleArea(circle2);
        System.out.println("area of circle : " + areaCircle);

        double areaSquare = calculateSquareArea(square2);
        System.out.println("area of square: " + areaSquare);

        double areaTriangle = calculateTriangleArea(triangle2);
        System.out.println("area of triangle : " + areaTriangle);
    }

    private static double calculateCircleArea(Figure figure) {
        if (figure instanceof Circle) {
            Circle circle = (Circle) figure; // Приведення до типу Circle
            double area = areaCircleException(circle);
            return area;
        } else {
            System.out.println("Об'єкт не є типом Circle");
            return 0.0; // Повернути значення за замовчуванням або обробити помилку, якщо потрібно
        }
    }

    private static double calculateSquareArea(Figure figure) {
        if (figure instanceof Square) {
            Square square = (Square) figure; // Приведення до типу Square
            double side = areaSquareException(square);
            return side;
        } else {
            System.out.println("Об'єкт не є типом Square");
            return 0.0; // Повернути значення за замовчуванням або обробити помилку, якщо потрібно
        }
    }

    private static double calculateTriangleArea(Figure figure) {
        if (figure instanceof Triangle) {
            Triangle triangle = (Triangle) figure;
            double angleInDegrees = areaTriangleException(triangle);
            return angleInDegrees; // Ось де маємо обчислити площу трикутника на основі його властивостей
        } else {
            System.out.println("Об'єкт не є типом Triangle");
            return 0.0;
        }
    }

    private static void displayTriangleAreaAndPerimetr(Triangle triangle) {
        System.out.println("Perimeter and area of triangle: ");
        double area1 = ((Triangle) triangle).area();
        System.out.println("Area triangle using Herons formula :  " + area1);
        double area2 = ((Triangle) triangle).area(30);
        System.out.println("area of triangle using the product of two sides per sine angle:  " + area2);
        double area3 = ((Triangle) triangle).area(8, 4);
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

    private static double areaCircleException(Figure figures) {
        for (; ; ) {
            Scanner scanner = new Scanner(System.in);
            double rad = scanner.nextDouble();
            double areaCircle = 0.0;

            if (figures instanceof Circle) {
                Circle circle = (Circle) figures;
                try {
                    if (rad <= 0) {
                        throw new ExceptionFigure("Radius is less than 0, enter a value greater than 0");
                    } else {
                        areaCircle = circle.area(rad);
                        return areaCircle;
                    }
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }
        }
    }

    private static double areaSquareException(Figure figures) {
        for (; ; ) {
            Scanner scanner = new Scanner(System.in);
            double sideSquare = scanner.nextDouble();
            double areaSquare = 0.0;

            if (figures instanceof Square) {
                Square square = (Square) figures;
                try {
                    if (sideSquare <= 0) {
                        throw new ExceptionFigure("side of square is less than 0, enter a value greater than 0");
                    } else {
                        areaSquare = square.area(sideSquare);
                        return areaSquare;
                    }
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                }
            }
        }
    }

    private static double areaTriangleException(Figure figure) {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter angle in degrees: ");
            double angleInDegrees = scanner.nextDouble();

            System.out.println("Enter sideA of the triangle: ");
            double sideA = scanner.nextDouble();

            System.out.println("Enter sideB of the triangle: ");
            double sideB = scanner.nextDouble();

            if (figure instanceof Triangle) {
                Triangle triangle = (Triangle) figure;
                try {
                    if (sideA > 0 && sideB > 0 && angleInDegrees > 0 && angleInDegrees < 180) {
                        // Перевірка нерівності трикутника
                        if ((sideA + sideB) > calculateThirdSide(sideA, sideB, angleInDegrees)
                                && (sideA + calculateThirdSide(sideA, sideB, angleInDegrees)) > sideB
                                && (sideB + calculateThirdSide(sideB, sideA, angleInDegrees)) > sideA) {
                            // Обчислити площу трикутника за допомогою синусу кута
                            double angleInRadians = Math.toRadians(angleInDegrees);
                            double area = (sideA * sideB * Math.sin(angleInRadians)) / 2.0;
                            return area;
                        } else {
                            throw new ExceptionFigure("Invalid triangle. The sum of two sides must be greater than the third side.");
                        }
                    } else {
                        throw new ExceptionFigure("Invalid triangle parameters. Make sure side lengths and angle are valid.");
                    }
                } catch (Exception exception) {
                    System.out.println(exception.getMessage());
                    return Double.NaN; // Повернути NaN, оскільки трикутник неможливий
                }
            }
        }
    }

    private static double calculateThirdSide(double sideA, double sideB, double angleInDegrees) {
        // Обчислити третю сторону за допомогою тригонометричних формул
        // c = sqrt(a^2 + b^2 - 2 * a * b * cos(C))
        double angleInRadians = Math.toRadians(angleInDegrees);
        return Math.sqrt(sideA * sideA + sideB * sideB - 2 * sideA * sideB * Math.cos(angleInRadians));
    }
}