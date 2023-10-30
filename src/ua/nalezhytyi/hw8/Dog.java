package ua.nalezhytyi.hw8;

public class Dog extends Animal{
    private String animalEat;
    private int animalSleep;
    public Dog(String animalEat, int animalSleep) {
        this.animalEat = animalEat;
        this.animalSleep = animalSleep;
    }
    public void eat(){
        System.out.println("dog is eat");
    }
    public void dogEating(){
        System.out.println("Dog eat: " + animalEat);
    }
    public void howMuchSleep(){
        System.out.println("Dog sleep " + animalSleep + " hours");
    }
}