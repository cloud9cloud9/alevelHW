package ua.nalezhytyi.hw9;

public class Square extends Figure {
    private double side;
    public Square(){}

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double perimeter() {
        return 4 * side;
    }

    @Override
    public double area() {
        return side * side;
    }

    public double area(double sideSquare) {
        return sideSquare * sideSquare;
    }
    @Override
    public String toString() {
        return "Square{" +
                '}';
    }
}
