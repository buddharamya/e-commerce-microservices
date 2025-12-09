package com.microserviceprojects.product_service.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductRequestDTO {

    private String name;
    private String description;
    private Double price;
    private Integer stock;
}
