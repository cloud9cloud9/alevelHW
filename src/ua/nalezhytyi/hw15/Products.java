package ua.nalezhytyi.hw15;

public class Products {
    private String nameOfProducts;
    private int quantity;
    private double price;


    @Override
    public String toString() {
        return "Products{" +
                "nameOfProducts='" + nameOfProducts + '\'' +
                ", quantityOfProducts=" + quantity +
                ", price=" + price +
                '}';
    }

    public double getPrice() {
        return price;
    }


    public int getQuantity() {
        return quantity;
    }


    public String getNameOfProducts() {
        return nameOfProducts;
    }


    public Products(String nameOfProducts, int quantity, double price) {
        this.nameOfProducts = nameOfProducts;
        this.quantity = quantity;
        this.price = price;
    }
}
