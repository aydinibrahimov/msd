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
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public ProductResponse getAllProducts() {
        List<ProductDTO> productDTOList = productRepository.findAll()
                .stream()
                .map(products -> convertToProductDTO(products))
                .collect(Collectors.toList());
        return makeProductResponse(productDTOList);
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


    public ProductDTO updateProductById(ProductDTO productDTO, Long id) {
        Product product = getProduct(id);
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        productRepository.save(product);
        return productDTO;
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
