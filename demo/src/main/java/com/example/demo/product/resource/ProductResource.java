package com.example.demo.product.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductResource {
    private Long id;
    private String name;
    private Integer stock;
    private Float price;
}
