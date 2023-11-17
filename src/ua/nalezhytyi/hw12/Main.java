package ua.nalezhytyi.hw12;


import java.util.*;

public class Main {
    public static void main(String[] args) {

        Comparator<Circle> lambdaComparatorOfArea = (Circle first, Circle second) -> {
            return (int) (first.area() - second.area());
        };
        Comparator<Circle> lambdaComparatorOfPerimeter = (Circle first, Circle second) -> {
            return (int) (first.perimeter() - second.perimeter());
        };
        lambdaComparatorOfArea.thenComparing(lambdaComparatorOfPerimeter);

        Circle firstCircle = new Circle(14);
        Circle secondCircle = new Circle(11);
        Circle thirdCircle = new Circle(13);
        Set<Circle> setsOfCircles = new TreeSet<>(lambdaComparatorOfArea);
        setsOfCircles.add(firstCircle);
        setsOfCircles.add(secondCircle);
        setsOfCircles.add(thirdCircle);
        List<Circle> listOfCircles = new ArrayList<>();
        listOfCircles.add(firstCircle);
        listOfCircles.add(secondCircle);
        listOfCircles.add(thirdCircle);
        Collections.sort(listOfCircles, lambdaComparatorOfArea);
        printSortedElementOfList(listOfCircles);

    }
    private static<T> void printSortedElementOfList(List<T> list){
        for (T c : list) {
            System.out.println(c);
        }
    }
}
