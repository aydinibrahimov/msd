package com.msd.msd.service;

import com.msd.msd.entity.Product;
import com.msd.msd.repository.ProductRepository;
import com.msd.msd.rest.model.dto.ProductDTO;
import com.msd.msd.rest.model.response.ProductResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with ID= " + id + " does not exist"));
    }


    public void deleteProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
        } else {
            product.orElseThrow(() -> new RuntimeException("Product with ID= " + id + " does not exist"));
        }

    }


    public Product addProduct(Product product) {
        return productRepository.save(product);
    }


    public Product updateProductById(Product product, Long id) {
        Optional<Product> p = productRepository.findById(id);
        if (p.isPresent()) {
            return productRepository.save(product);
        } else {
            return p.orElseThrow(() -> new RuntimeException("Product with ID= " + id + " does not exist"));
        }
    }


    private ProductDTO convertToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);
        return productDTO;
    }

    private ProductResponse makeProductResponse(List<ProductDTO> productDTOList) {
        return ProductResponse.builder()
                .products(productDTOList)
                .build();

    }


}
