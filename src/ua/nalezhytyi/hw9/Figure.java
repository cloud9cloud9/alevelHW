package ua.nalezhytyi.hw9;

public abstract class Figure {
    public abstract double perimeter();
    public abstract double area();

    @Override
    public String toString() {
        return "Figure{}";
    }
}
