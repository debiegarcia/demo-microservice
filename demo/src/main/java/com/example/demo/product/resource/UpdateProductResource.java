package com.example.demo.product.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateProductResource {
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    private Integer stock;

    @NotNull
    private Float price;
}
