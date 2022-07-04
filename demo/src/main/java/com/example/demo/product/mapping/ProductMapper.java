package com.example.demo.product.mapping;

import com.example.demo.product.domain.model.entity.Product;
import com.example.demo.product.resource.CreateProductResource;
import com.example.demo.product.resource.ProductResource;
import com.example.demo.product.resource.UpdateProductResource;
import com.example.demo.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public class ProductMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;

    public ProductResource toResource(Product model){
        return mapper.map(model, ProductResource.class);
    }

    public List<ProductResource> toResource(List<Product> model){
        return mapper.mapList(model, ProductResource.class);
    }

    public Product toModel(CreateProductResource resource){
        return mapper.map(resource, Product.class);
    }

    public Product toModel(UpdateProductResource resource){
        return mapper.map(resource, Product.class);
    }
}
