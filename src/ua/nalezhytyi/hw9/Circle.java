package ua.nalezhytyi.hw9;

public class Circle extends Figure{
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double perimeter() {
        return 2 * PI * radius;
    }

    @Override
    public double area() {
        return PI * (radius * radius);
    }
}
