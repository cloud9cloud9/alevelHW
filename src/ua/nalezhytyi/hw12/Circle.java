package ua.nalezhytyi.hw12;



public class Circle  {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }


    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public double area() {
        return Math.PI * (radius * radius);
    }

    @Override
    public String toString() {
        return "Circle {" + " area is " + area() + " perimeter is " + perimeter() +
                '}';
    }
}
