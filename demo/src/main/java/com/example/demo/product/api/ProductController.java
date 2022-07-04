package com.example.demo.product.api;

import com.example.demo.product.domain.service.ProductService;
import com.example.demo.product.mapping.ProductMapper;
import com.example.demo.product.resource.CreateProductResource;
import com.example.demo.product.resource.ProductResource;
import com.example.demo.product.resource.UpdateProductResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Product")
@RestController
@RequestMapping("api/v1/products")
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductMapper productMapper;

    @Operation(summary = "Get All Products", description = "Get All Products")
    @GetMapping()
    public List<ProductResource> getAll(){
        return productMapper.toResource(productService.getAll());
    }

    @Operation(summary = "Get Product by Id", description = "Get Product by Id")
    @GetMapping("{productId}")
    public ProductResource getProductById(@PathVariable Long productId){
        return productMapper.toResource(productService.getById(productId));
    }

    @Operation(summary = "Create New Product", description = "Create New Product")
    @PostMapping()
     public ProductResource createProduct(@RequestBody CreateProductResource model){
        return productMapper.toResource(productService.create(productMapper.toModel(model)));
    }

    @Operation(summary = "Update Product", description = "Update Product")
    @PutMapping("{productId}")
    public ProductResource updateProduct(@PathVariable Long productId, @RequestBody UpdateProductResource model){
        return productMapper.toResource(productService.update(productId, productMapper.toModel(model)));
    }

    @Operation(summary = "Delete Product", description = "Delete Product")
    @DeleteMapping("{productId}")
    public void deleteProduct(@PathVariable Long productId){
        productService.delete(productId);
    }

}
