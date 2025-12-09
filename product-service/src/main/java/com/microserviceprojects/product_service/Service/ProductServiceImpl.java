package com.microserviceprojects.product_service.Service;

import com.microserviceprojects.product_service.DTO.ProductRequestDTO;
import com.microserviceprojects.product_service.DTO.ProductResponseDTO;
import com.microserviceprojects.product_service.DTO.ProductStockUpdateDTO;
import com.microserviceprojects.product_service.Entity.ProductEntity;
import com.microserviceprojects.product_service.Repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductResponseDTO addProduct(ProductRequestDTO request) {

        ProductEntity product = new ProductEntity();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        ProductEntity dbProduct = productRepository.save(product);

        return mapToDTO(dbProduct);
    }

    private ProductResponseDTO mapToDTO(ProductEntity dbProduct) {

        ProductResponseDTO dto = new ProductResponseDTO();
        // Instead of writing manual setters, you can quickly transfer values from one object to another.
        BeanUtils.copyProperties(dbProduct,dto);
        return dto;
    }

    @Override
    public ProductResponseDTO getProductById(Long productId) {
        return productRepository.findById(productId)
                .map(this::mapToDTO)    // alternative for Lambda expression .map(product->mapToDTO(product))
                .orElseThrow(()-> new RuntimeException("Product Not Found"));
    }

    @Override
    public boolean isProductExists(Long productId) {
        return productRepository.existsById(productId);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        return productRepository.findAll().stream().map(product -> mapToDTO(product)).toList();
    }

    @Override
    public void updateStock(List<ProductStockUpdateDTO> updates) {

        List<ProductEntity> updatedProducts = new ArrayList<>();

        for(ProductStockUpdateDTO dto : updates)
        {
            ProductEntity product = productRepository.findById(dto.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product Not Found"));

            if(product.getStock() < dto.getQuantity()) {
                throw new RuntimeException("Insufficient stock for productid" + dto.getProductId());
            }
            product.setStock(product.getStock()-dto.getQuantity());
            updatedProducts.add(product);
        }
        productRepository.saveAll(updatedProducts); // batch save

    }
}
