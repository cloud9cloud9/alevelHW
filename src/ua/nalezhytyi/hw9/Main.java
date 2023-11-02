package ua.nalezhytyi.hw9;

public class Main {
    public static void main(String[] args) {
        Figure circle = new Circle(10);
        Triangle triangle = new Triangle(10, 10, 2);
        Figure square = new Square(3);
        returnCircleAreaAndPerimetr(circle);
        returnSquareAreaAndPerimetr(square);
        returnTriangleAreaAndPerimetr(triangle);

    }
    private static void returnTriangleAreaAndPerimetr(Triangle triangle){
        double area1 = triangle.area();
        System.out.println("Area triangle using Herons formula :  " + area1);
        double area2 = triangle.area(30);
        System.out.println("area of triangle using the product of two sides per sine angle:  " + area2);
        double area3 = triangle.area(6, 8);
        System.out.println("area using a base height product:  " + area3);
        double circlePerimetr = triangle.perimeter();
        System.out.println("perimetr triangle = " + circlePerimetr);
    }
    private static void returnCircleAreaAndPerimetr(Figure figure){
        double circleArea = figure.area();
        System.out.println("Area circle : " + circleArea);
        double circlePerimetr = figure.perimeter();
        System.out.println("perimetr circle = " + circlePerimetr);
    }
    private static void returnSquareAreaAndPerimetr(Figure figure){
        double squareArea = figure.area();
        System.out.println("Area square : " + squareArea);
        double squarePerimetr = figure.perimeter();
        System.out.println("Perimetr of square = " + squarePerimetr);
    }
}
