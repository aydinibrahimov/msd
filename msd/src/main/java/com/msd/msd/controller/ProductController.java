package com.msd.msd.controller;

import com.msd.msd.entity.Product;
import com.msd.msd.rest.model.dto.ProductDTO;
import com.msd.msd.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/msd/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Product insertProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable Long id) {
        return productService.updateProductById(product, id);
    }

    @DeleteMapping("/{id}")
    public void removeProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
    }


    @GetMapping("/{id}")
    public ProductDTO findProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping
    public List<Product> findAllProducts() {
        return productService.getAllProducts();
    }
}
