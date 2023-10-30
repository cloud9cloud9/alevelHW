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
    public final void howMuchSleepfinal(int animalSleep) {
        System.out.println("Animal is " + animalSleep + " hours sleeping");
    }
    public void getAnimalEat() {
        System.out.println("animal eat: " + animalEat);
    }
    public void setAnimalEat(String animalSay) {
        this.animalEat = animalSay;
    }
    public int getAnimalSleep() {
        return animalSleep;
    }
    public int setAnimalSleep(int animalSleep) {
        this.animalSleep = animalSleep;
        return animalSleep;
    }
    public static Animal findSleepyAnimal(Animal[] animals) {
        Animal isMoreSleep = animals[0];
        for (int i = 0; i < animals.length; i++) {
            if (animals[i].getAnimalSleep() > isMoreSleep.getAnimalSleep()) {
                isMoreSleep = animals[i];
            }
        }
        return isMoreSleep;
    }
    @Override
    public String toString() {
        return "Animal{" +
                "animalEat='" + animalEat + '\'' +
                '}';
    }
}
