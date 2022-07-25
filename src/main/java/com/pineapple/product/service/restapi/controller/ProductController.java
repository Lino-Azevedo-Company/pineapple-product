package com.pineapple.product.service.restapi.controller;

import com.pineapple.product.service.domain.product.ProductService;
import com.pineapple.product.service.restapi.wrapper.ListWrapper;
import com.pineapple.product.service.restapi.wrapper.ProductWrapper;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping("/")
    public ListWrapper<ProductWrapper> findAll(){
        return new ListWrapper<>(service.findAll(), ProductWrapper::new);
    }

    @GetMapping("/{id}")
    public ProductWrapper findById(@PathVariable("id") final Long id){
        return new ProductWrapper(service.findById(id));
    }
}
