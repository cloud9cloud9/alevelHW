package ua.nalezhytyi.hw8;

public class Main {
    public static void main(String[] args) {
        Animal cat = new Animal("fish", 2);
        Animal dog = new Animal("Meat" , 5);
        Animal pinguin = new Animal("fish of sea", 1);
        Animal [] animals = {cat, dog, pinguin};
        Animal animalWithLongestSleep = findAnimalWithLongestSleep(animals);
        System.out.println(animalWithLongestSleep);
        Dog dogs = new Dog();
        Dog beagle = new Dog("meat" , 44);
        beagle.dogEating();
        dogs.setAnimalSleep(10);
        dogs.setAnimalEat("Meat");
        dogs.eat();
        dogs.getAnimalEat();
        dogs.howMuchSleep();
        dogs.printSleepHours(9);
    }
    private static Animal findAnimalWithLongestSleep(Animal[] animals) {
        Animal isMoreSleep = animals[0];
        for (int i = 0; i < animals.length; i++) {
            if (animals[i].getAnimalSleep() > isMoreSleep.getAnimalSleep()) {
                isMoreSleep = animals[i];
            }
        }
        return isMoreSleep;
    }
}
