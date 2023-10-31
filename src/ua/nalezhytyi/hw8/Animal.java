package ua.nalezhytyi.hw8;

public class Animal {
    private String animalEat;
    private int animalSleep;

    public Animal(String animalEat, int animalSleep) {
        this.animalEat = animalEat;
        this.animalSleep = animalSleep;
    }
    public Animal() {
    }

    public void eat() {
        System.out.println("animal is eat");
    }
    public final void printSleepHours(int animalSleep) {
        System.out.println("Animal is " + animalSleep + " hours sleeping");
    }
    public String getAnimalEat() {
        return animalEat;
    }
    public void setAnimalEat(String animalEat) {
        this.animalEat = animalEat;
    }
    public int getAnimalSleep() {
        return animalSleep;
    }
    public int setAnimalSleep(int animalSleep) {
        this.animalSleep = animalSleep;
        return animalSleep;
    }
    @Override
    public String toString() {
        return "Animal{" +
                "animalEat='" + animalEat + '\'' +
                '}';
    }
}
