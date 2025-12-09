package com.microserviceprojects.product_service.Service;

import com.microserviceprojects.product_service.DTO.ProductRequestDTO;
import com.microserviceprojects.product_service.DTO.ProductResponseDTO;
import com.microserviceprojects.product_service.DTO.ProductStockUpdateDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    ProductResponseDTO addProduct(ProductRequestDTO request);
    ProductResponseDTO getProductById(Long productId);
    boolean isProductExists(Long productId);
    List<ProductResponseDTO> getAllProducts();
    void updateStock(List<ProductStockUpdateDTO> updates);
}
