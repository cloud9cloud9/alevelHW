package ua.nalezhytyi.hw6;

public class Phone {
    String number;
    String model;
    double weight;

    public static void main(String[] args) {
        Phone phone = new Phone("88005553535", "Iphone9", 0.150);
        Phone phoneSecond = new Phone("999666999", "Samsung f20", 0.222);
        Phone phoneThird = new Phone("992391919", "iphone 999", 0.666);
        System.out.println(phone);
        System.out.println(phoneSecond);
        System.out.println(phoneThird);
        phone.receiveCall(" Johan");
        phone.getNumber();

    }
    public Phone(String number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }
    public Phone(String number, String model){
        this.number = number;
        this.model = model;
    }
    public Phone(){
    }
    public String toString(){
        return "Phone number is: " + number + ", phone model is: " + model +", phone weight is: " + weight;
    }
    public void receiveCall(String name){
        System.out.println("Вам звонить" + name);
    }
    public void getNumber(){
        this.number = number;
        System.out.println("Номер телефону: " + number);
    }
}
