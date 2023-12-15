package ua.nalezhytyi.hw15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Vladick\\IdeaProjects\\alevelhomework" +
                "\\src\\ua\\nalezhytyi\\hw15\\Input.txt");
        File fileOutput = new File("C:\\Users\\Vladick\\IdeaProjects\\alevelhomework\\src\\ua\\nalezhytyi\\hw15\\Output.txt");
        fileOutput.createNewFile();

        List<Products> products = readFile(file);
        String filePath = fileOutput.getAbsolutePath();

        List<String> outputData = new ArrayList<>();

        filterProductsByQuantity(products, 3, outputData);
        summaryQuantityOfProduct(products, outputData);
        calculateAveragePrice(products, outputData);
        sortedProductsByPrice(products, outputData);
        summaryPriceOfAllProduct(products, outputData);

        writeToOutputFile(outputData, filePath);


    }

    private static List<Products> readFile(File fileInput) {
        List<Products> listOfProduct = new ArrayList<>();

        try(RandomAccessFile randomAccessFile = new RandomAccessFile(fileInput, "rw")) {
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listOfProduct;
    }

    private static void filterProductsByQuantity(List<Products> productsList, int quantityOfProducts, List<String> outputData){
        List<String> newList = productsList.stream()
                .filter(s -> s.getQuantity() >= quantityOfProducts)
                .map(product -> "Filter by quantity" + "Name of Products " + product.getNameOfProducts() + " Quantity of products "
                        + product.getQuantity())
                .collect(Collectors.toList());

        outputData.addAll(newList);
    }

    private static void summaryQuantityOfProduct(List<Products> productsList, List<String> outputData) {
        int sumQuantity = productsList.stream()
                .mapToInt(Products::getQuantity)
                .sum();
        String representSumQuantityByString = "Summary quantity of all products " + String.valueOf(sumQuantity);
        outputData.add(representSumQuantityByString);
    }

    private static void calculateAveragePrice(List<Products> productsList, List<String> outputData) {
        double sumQuantity = productsList.stream()
                .mapToDouble(Products::getQuantity)
                .sum();
        double sumPrice = productsList.stream()
                .mapToDouble(product -> product.getQuantity() * product.getPrice())
                .sum();

        double averagePrice = sumPrice / sumQuantity;
        double roundedAverage = Math.round(averagePrice * 100.0) / 100.0;
        String sumQuantities = "Average price of product " + roundedAverage;

        outputData.add(sumQuantities);

    }

    private static void sortedProductsByPrice(List<Products> productsList, List<String> outputData){
        Comparator<Products> comparatorOfPrice = Comparator.comparing(Products::getPrice);
        List<String> newList = productsList.stream()
                .sorted(comparatorOfPrice.reversed())
                .map(s -> "Sorted by price: " + " Name of products " + s.getNameOfProducts() + " and price of this product is " + s.getPrice())
                .collect(Collectors.toList());

        outputData.addAll(newList);
    }

    private static void summaryPriceOfAllProduct(List<Products> productsList, List<String> outputData) {
        double summary = productsList.stream()
                .mapToDouble(product -> product.getQuantity() * product.getPrice())
                .sum();
        String summaryPriceOfAllProd = "Summary price of all products " + String.valueOf(summary);

        outputData.add(summaryPriceOfAllProd);
    }

    private static void writeToOutputFile(List<String> data, String filePath)  {
        Path outputPath = Paths.get(filePath);
        try {
            if (Files.size(outputPath) > 0) {
                Files.write(outputPath, data, StandardCharsets.UTF_8, StandardOpenOption.TRUNCATE_EXISTING);
            } else {
                Files.write(outputPath, data, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}