package com.example;

import com.example.model.Product;
import com.example.service.ProductService;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        // Product product = new Product(1, "Laptop", 50000.0);
        // System.out.println("Product Name: " + product.getName());
        ProductService productService = new ProductService();

        System.out.println("--- All Product Names ---");
        List<String> productNames = productService.getProductNames();
        productNames.forEach(System.out::println);

        System.out.println("\n--- Products Above Price 10000 ---");
        List<Product> expensiveProducts = productService.getProductsAbovePrice(10000.0);
        expensiveProducts.forEach(p -> 
            System.out.println(p.getName() + ": ₹" + p.getPrice())
        );

        System.out.println("\n--- Searching for Product by ID 2 ---");
        Optional<String> productName = productService.getProductNameById(2L);
        productName.ifPresentOrElse(
            name -> System.out.println("Found: " + name),
            () -> System.out.println("Product not found")
        );

        System.out.println("\n--- Searching for Product by ID 10 (Null Safety) ---");
        Optional<String> missingProductName = productService.getProductNameById(10L);
        missingProductName.ifPresentOrElse(
            name -> System.out.println("Found: " + name),
            () -> System.out.println("Product not found")
        );
    }
}