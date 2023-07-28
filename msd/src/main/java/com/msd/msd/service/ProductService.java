package com.msd.msd.service;

import com.msd.msd.entity.Product;
import com.msd.msd.enums.CustomErrorCode;
import com.msd.msd.exception.CustomException;
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


    public ProductDTO getProductById(Long id) {
        return convertToProductDTO(getProduct(id));
    }


    public void deleteProductById(Long id) {
        productRepository.delete(getProduct(id));
    }


    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        productRepository.save(product);
        return productDTO;
    }


    public Product updateProductById(Product product, Long id) {
        Optional<Product> p = productRepository.findById(id);
        if (p.isPresent()) {
            return productRepository.save(product);
        } else {
            return p.orElseThrow(() -> new RuntimeException("Product with ID= " + id + " does not exist"));
        }
    }


    private Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new CustomException(CustomErrorCode.PRODUCT_NOT_FOUND));
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
