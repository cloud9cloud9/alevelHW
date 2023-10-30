package ua.nalezhytyi.hw8;

public class Main {
    public static void main(String[] args) {
        Animal cat = new Animal("fish", 10);
        Animal dog = new Animal("meat", 9);
        Animal pinguin = new Animal("fish of sea", 12);
        Animal [] animals = {cat, dog, pinguin};
        Animal whatIsAnimalEating = Animal.findSleepyAnimal(animals);
        System.out.println(whatIsAnimalEating);
        Dog dogs = new Dog("feed", 10);
        dogs.eat();
        dogs.dogEating();
        dogs.howMuchSleep();
        dogs.howMuchSleepfinal(9);
    }
}
