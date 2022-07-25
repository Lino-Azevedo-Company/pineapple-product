package com.pineapple.product.service.restapi.wrapper;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pineapple.product.service.domain.product.Product;
import com.pineapple.product.service.restapi.deserialization.ProductDeserializer;
import com.pineapple.product.service.restapi.serialization.ProductSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@JsonSerialize(using = ProductSerializer.class)
@JsonDeserialize(using = ProductDeserializer.class)
public class ProductWrapper {

    @Getter
    private final Product product;
}
