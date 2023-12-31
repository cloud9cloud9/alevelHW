package ua.nalezhytyi.hw9;

public  class Circle extends Figure{
    private double radius;
    public Circle(){}

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double area() {
        return Math.PI * (radius * radius);
    }

    public double area(double radius) {
        return Math.PI * (radius * radius);
    }

    @Override
    public String toString() {
        return "Circle {" +
                '}';
    }
}
