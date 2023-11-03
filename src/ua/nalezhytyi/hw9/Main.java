package ua.nalezhytyi.hw9;

public class Main {
    public static void main(String[] args) {
        Figure circle = new Circle(10);
        Triangle triangle = new Triangle(10, 10, 2);
        Figure square = new Square(3);
        displayCircleAreaAndPerimetr(circle);
        displaySquareAreaAndPerimetr(square);
        displayTriangleAreaAndPerimetr(triangle);
        Figure[] figures = {circle, triangle, square};
        displayFigureWithBiggestArea(figures);

    }
    private static void displayTriangleAreaAndPerimetr(Triangle triangle){
        double area1 = triangle.area();
        System.out.println("Area triangle using Herons formula :  " + area1);
        double area2 = triangle.area(30);
        System.out.println("area of triangle using the product of two sides per sine angle:  " + area2);
        double area3 = triangle.area(6, 8);
        System.out.println("area using a base height product:  " + area3);
        double circlePerimetr = triangle.perimeter();
        System.out.println("perimetr triangle = " + circlePerimetr);
    }
    private static void displayCircleAreaAndPerimetr(Figure figure){
        double circleArea = figure.area();
        System.out.println("Area circle : " + circleArea);
        double circlePerimetr = figure.perimeter();
        System.out.println("perimetr circle = " + circlePerimetr);
    }
    private static void displaySquareAreaAndPerimetr(Figure figure){
        double squareArea = figure.area();
        System.out.println("Area square : " + squareArea);
        double squarePerimetr = figure.perimeter();
        System.out.println("Perimetr of square = " + squarePerimetr);
    }
    private static void displayFigureWithBiggestArea(Figure[] figures){
        Figure area = figures[0];
        for (int i = 0; i < figures.length - 1; i++) {
            if(figures[i].area() < figures[i + 1].area()){
                area = figures[i + 1];
            }
        }
        System.out.println("Фігура з найбільшею площею " + area);
    }
}
