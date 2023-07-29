package com.msd.msd.controller;

import com.msd.msd.rest.model.dto.ProductDTO;
import com.msd.msd.rest.model.response.ProductResponse;
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
    public ProductDTO insertProduct(@RequestBody ProductDTO productDTO) {
        return productService.addProduct(productDTO);
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO, @PathVariable Long id) {
        return productService.updateProductById(productDTO, id);
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
    public ProductResponse findAllProducts() {
        return productService.getAllProducts();
    }
}
