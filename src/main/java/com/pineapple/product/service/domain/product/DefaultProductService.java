package com.pineapple.product.service.domain.product;

import com.pineapple.product.service.infra.exception.ItemNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DefaultProductService implements ProductService {

    private final ProductRepository repository;

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new ItemNotFoundException(String.format("Produto com id %d não existe", id)));
    }
}
