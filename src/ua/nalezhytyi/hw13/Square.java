package ua.nalezhytyi.hw13;



public class Square extends Figure {
    private double side;

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

    @Override
    public String toString() {
        return "Square{" + " area is " + area() + " perimeter is " + perimeter() +
                '}';
    }
}
