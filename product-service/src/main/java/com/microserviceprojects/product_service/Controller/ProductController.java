package com.microserviceprojects.product_service.Controller;

import com.microserviceprojects.product_service.DTO.ProductRequestDTO;
import com.microserviceprojects.product_service.DTO.ProductResponseDTO;
import com.microserviceprojects.product_service.DTO.ProductStockUpdateDTO;
import com.microserviceprojects.product_service.Service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponseDTO> addProduct(@RequestBody ProductRequestDTO request) {
        log.info("productController addProduct");
        return new ResponseEntity<>(productService.addProduct(request), HttpStatus.CREATED);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable Long productId) {
        log.info("productController getProductById");
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @GetMapping
    public List<ProductResponseDTO> getAllProducts() {
        log.info("productController getAllProducts");
        return productService.getAllProducts();
    }

    @GetMapping("/exists/{productId}")
    public boolean isProductExists(@PathVariable Long productId) {
        log.info("productController isProductExists");
        return productService.isProductExists(productId);
    }
    
    @PutMapping("/update-stock")
    public ResponseEntity<Void> updateProductStock(@RequestBody List<ProductStockUpdateDTO> request) {
        log.info("ProductController updateProductStock");
        productService.updateStock(request);
        return ResponseEntity.ok().build();
    }
}
