package com.msd.msd.service;

import com.msd.msd.entity.Product;
import com.msd.msd.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with ID= " + id + " does not exist"));
    }

    public boolean deleteProductById(Long id) {

        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
        } else {
            product.orElseThrow(() -> new RuntimeException("Product with ID= " + id + " does not exist"));
        }
        return true;
    }

    public Product addProduct(Product product) {
        productRepository.save(product);
        return product;
    }

    public boolean updateProduct(Product product, Long id) {
        Optional<Product> p = productRepository.findById(id);
        if (p.isPresent()) {
            productRepository.save(product);
        } else {
            p.orElseThrow(() -> new RuntimeException("Product with ID= " + id + " does not exist"));
        }
        return true;
    }


}
