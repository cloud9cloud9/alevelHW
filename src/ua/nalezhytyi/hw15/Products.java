package ua.nalezhytyi.hw15;

public class Products {
    String nameOfProducts;
    int quantity;
    double price;


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

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNameOfProducts() {
        return nameOfProducts;
    }

    public void setNameOfProducts(String nameOfProducts) {
        this.nameOfProducts = nameOfProducts;
    }

    public Products(String nameOfProducts, int quantity, double price) {
        this.nameOfProducts = nameOfProducts;
        this.quantity = quantity;
        this.price = price;
    }
}
