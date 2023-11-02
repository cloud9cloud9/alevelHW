package ua.nalezhytyi.hw9;

public class Square extends Figure {
    double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double perimeter() {
        return side + side + side + side;
    }

    @Override
    public double area() {
        return side * side;
    }
}
