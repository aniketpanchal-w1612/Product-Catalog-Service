package com.example.service;

import com.example.model.Product;
import com.example.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    /**
     * Returns products above a certain price using the database.
     */
    public List<Product> getProductsAbovePrice(double price) {
        return repository.findByPriceGreaterThan(price);
    }

    /**
     * Returns only product names using map()
     */
    public List<String> getProductNames() {
        return repository.findAll().stream()
                .map(Product::getName)
                .collect(Collectors.toList());
    }

    /**
     * Returns an Optional containing the product name if found by ID
     */
    public Optional<String> getProductNameById(Long id) {
        return repository.findById(id)
                .map(Product::getName);
    }

    public Optional<Product> getProductById(Long id) {
        return repository.findById(id);
    }
    
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product addProduct(Product product){
        return repository.save(product);
    }
}
