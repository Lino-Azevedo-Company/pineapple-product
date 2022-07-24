package com.pineapple.product.service.restapi.controller;

import com.pineapple.product.service.domain.product.Product;
import com.pineapple.product.service.domain.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping("/")
    public List<Product> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") final Long id){
        return service.findById(id);
    }
}
