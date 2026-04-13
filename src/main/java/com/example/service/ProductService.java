package com.example.service;

import com.example.model.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();

    public ProductService() {
        // Add sample products (3–5 items)
        products.add(new Product(1L, "Laptop", 55000.0));
        products.add(new Product(2L, "Smartphone", 25000.0));
        products.add(new Product(3L, "Headphones", 5000.0));
        products.add(new Product(4L, "Monitor", 12000.0));
        products.add(new Product(5L, "Keyboard", 1500.0));
    }

    /**
     * Implement method: public List<Product> getProductsAbovePrice(double price)
     * Use Streams to filter products
     */
    public List<Product> getProductsAbovePrice(double price) {
        return products.stream()
                .filter(p -> p.getPrice() > price)
                .collect(Collectors.toList());
    }

    /**
     * Add another method: Return only product names using map()
     */
    public List<String> getProductNames() {
        return products.stream()
                .map(Product::getName)
                .collect(Collectors.toList());
    }

    /**
     * Handle null safely using Optional
     * Returns an Optional containing the product name if found by ID
     */
    public Optional<String> getProductNameById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .map(Product::getName)
                .findFirst();
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }
    
    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
}
