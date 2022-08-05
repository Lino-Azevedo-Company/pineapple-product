package com.pineapple.product.service.domain.product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Long id);
}
