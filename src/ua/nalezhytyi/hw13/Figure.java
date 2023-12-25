package ua.nalezhytyi.hw13;


public abstract class Figure implements Comparable<Figure> {
    public abstract double perimeter();

    @Override
    public int compareTo(Figure o){
        return Double.compare(area(), o.area());
    }

    public abstract double area();

    @Override
    public String toString() {
        return "Figure{}";
    }
}


