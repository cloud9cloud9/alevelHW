package ua.nalezhytyi.hw9;

public class Triangle extends Figure {
    private double aSide;
    private double bSide;
    private double cSide;

    public Triangle(double aSide, double bSide, double cSide) {
        this.aSide = aSide;
        this.bSide = bSide;
        this.cSide = cSide;
    }

    @Override
    public double perimeter() {
        return aSide + bSide + cSide;
    }

    @Override
    // area of triangle using Heron's formula
    public double area() {
        //A = √(s * (s - a) * (s - b) * (s - c), where s = (a + b +c ) / 2;
        double halfOfPerimeter = (aSide + bSide + cSide) / 2;
        double areaUsingHeronFormula = Math.sqrt(halfOfPerimeter * (halfOfPerimeter - aSide) * (halfOfPerimeter - bSide)
                * (halfOfPerimeter - cSide));
        return areaUsingHeronFormula;
    }

    // area of triangle using the product of two sides per sine angle
    public double area(double angleInDegrees) {
        double angleInRadians = Math.toRadians(angleInDegrees);
        return 0.5 * aSide * bSide * Math.sin(angleInRadians);
    }

    // area using a base height product
    public static double area(double base, double height) {
        return 0.5 * base * height;
    }

    @Override
    public String toString() {
        return "Triangle{"
                + area() +
                '}';
    }
}
