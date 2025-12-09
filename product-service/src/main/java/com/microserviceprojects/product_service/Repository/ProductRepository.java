package com.microserviceprojects.product_service.Repository;

import com.microserviceprojects.product_service.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

}
