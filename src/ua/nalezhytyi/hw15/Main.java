package ua.nalezhytyi.hw15;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Vladick\\IdeaProjects\\alevelhomework" +
                "\\src\\ua\\nalezhytyi\\hw15\\Input.txt");
        File fileOutput = new File("C:\\Users\\Vladick\\IdeaProjects\\alevelhomework\\src\\ua\\nalezhytyi\\hw15\\Output.txt");
        fileOutput.createNewFile();

        List<Products> products = readFile(file);
        String filePath = "C:\\Users\\Vladick\\IdeaProjects\\alevelhomework\\src\\ua\\nalezhytyi\\hw15\\Output.txt";


        filterProductsByQuantity(products, 3, filePath);
        summaryQuantityOfProduct(products, filePath);
        calculateAveragePrice(products, filePath);
        sortedProductsByPrice(products, filePath);
        summaryPriceOfAllProduct(products, filePath);


    }

    private static List<Products> readFile(File fileInput) throws IOException {
        List<Products> listOfProduct = new ArrayList<>();
        RandomAccessFile randomAccessFile = new RandomAccessFile(fileInput, "rw");

        String line;
        while ((line = randomAccessFile.readLine()) != null) {
            String[] parts = line.split("\\|");

            if (parts.length == 3) {
                String productName = parts[0].trim();
                int quantity = Integer.parseInt(parts[1].trim());
                double price = Double.parseDouble(parts[2].trim());

                Products products = new Products(productName, quantity, price);
                listOfProduct.add(products);
            }
        }
        randomAccessFile.close();
        return listOfProduct;
    }

    private static void filterProductsByQuantity(List<Products> productsList, int quantityOfProducts, String folderPath) throws IOException {
        List<String> newList = productsList.stream()
                .filter(s -> s.getQuantity() >= quantityOfProducts)
                .map(product -> "Name of Products " + product.getNameOfProducts() + " Quantity of products "
                + product.getQuantity())
                .collect(Collectors.toList());

        Path folder = Paths.get(folderPath);
        Path filePath = folder.resolve("C:\\Users\\Vladick\\IdeaProjects\\alevelhomework\\src\\ua\\" +
                "nalezhytyi\\hw15\\Output.txt");
        Files.write(filePath, newList, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    }

    private static void summaryQuantityOfProduct(List<Products> productsList, String folderPath) throws IOException {
        int sumQuantity = productsList.stream()
                .mapToInt(Products::getQuantity)
                .sum();
        String sumQuantities ="Summary quantity of all products " + String.valueOf(sumQuantity);
        Path folder = Paths.get(folderPath);
        Path filePath = folder.resolve("C:\\Users\\Vladick\\IdeaProjects\\alevelhomework\\src\\ua\\" +
                "nalezhytyi\\hw15\\Output.txt");
        Files.write(filePath, Collections.singleton(sumQuantities), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    }

    private static void calculateAveragePrice(List<Products> productsList, String folderPath) throws IOException {
        double sumQuantity = productsList.stream()
                .mapToDouble(Products::getQuantity)
                .sum();
        double sumPrice = productsList.stream()
                .mapToDouble(Products::getPrice)
                .sum();

        String sumQuantities = "Avarage price of product " + String.valueOf(sumPrice / sumQuantity);
        Path folder = Paths.get(folderPath);
        Path filePath = folder.resolve("C:\\Users\\Vladick\\IdeaProjects\\alevelhomework\\src\\ua\\" +
                "nalezhytyi\\hw15\\Output.txt");
        Files.write(filePath, Collections.singleton(sumQuantities), StandardCharsets.UTF_8, StandardOpenOption.APPEND);


    }

    private static void sortedProductsByPrice(List<Products> productsList, String folderPath) throws IOException {
        Comparator<Products> comparatorOfPrice = Comparator.comparing(Products::getPrice);
        List<String> newList = productsList.stream()
                .sorted(comparatorOfPrice.reversed())
                .map(s -> "Name of products " + s.getNameOfProducts() + " and price of this product is " + s.getPrice())
                .collect(Collectors.toList());
        Path folder = Paths.get(folderPath);
        Path filePath = folder.resolve("C:\\Users\\Vladick\\IdeaProjects\\alevelhomework\\src\\ua\\" +
                "nalezhytyi\\hw15\\Output.txt");
        Files.write(filePath, newList, StandardCharsets.UTF_8, (OpenOption) StandardOpenOption.APPEND);
    }

    private static void summaryPriceOfAllProduct(List<Products> productsList, String folderPath) throws IOException {
        double summary = productsList.stream()
                .mapToDouble(product -> product.getQuantity() * product.getPrice())
                .sum();
        String summaryPriceOfAllProd ="Summary price of all products " + String.valueOf(summary);
        Path folder = Paths.get(folderPath);
        Path filePath = folder.resolve("C:\\Users\\Vladick\\IdeaProjects\\alevelhomework\\src\\ua\\" +
                "nalezhytyi\\hw15\\Output.txt");
        Files.write(filePath, Collections.singleton(summaryPriceOfAllProd), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    }
}
