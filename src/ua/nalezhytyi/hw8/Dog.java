package ua.nalezhytyi.hw8;

import java.io.PrintStream;

public class Dog extends Animal{
    public Dog(String animalEat, int animalSleep) {
        super(animalEat, animalSleep);
    }
    public void eat(){
        System.out.println("dog is eat");
    }
    public Dog() {

    }
    public void dogEating() {
        System.out.println("Dog eating a " + getAnimalEat());
    }
    public void howMuchSleep(){
        System.out.println("Dog sleep " + getAnimalSleep() + " hours");
    }
}
