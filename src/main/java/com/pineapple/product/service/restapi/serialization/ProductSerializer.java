package com.pineapple.product.service.restapi.serialization;

import com.pineapple.product.service.restapi.wrapper.ProductWrapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.pineapple.product.service.restapi.serialization.SerializationLabels.*;

@Component
public class ProductSerializer extends AbstractJsonSerializer<ProductWrapper> {

    @Override
    public void serialize(ProductWrapper productWrapper, Enum<?> fieldName, JsonBuilder builder) throws IOException {
        var product = productWrapper.getProduct();
        builder.writeStartObject()
                .writeNumberField(ID, product.getId())
                .writeStringField(NAME, product.getName())
                .writeStringField(DESCRIPTION, product.getDescription())
                .writeStringField(ADDITIONAL_DESCRIPTION, product.getAdditionalDescription())
                .writeStringField(MODEL, product.getModel())
                .writeNumberField(PRICE, product.getPrice())
                .writeNumberField(DISCOUNT, product.getDiscount())
                .writeNumberField(WEIGHT, product.getWeight())
                .writeStringField(DIMENSIONS, product.getDimensions())
                .writeNumberField(PACKING_WEIGHT, product.getPackingWeight())
                .writeStringField(PACKING_DIMENSIONS, product.getPackingDimensions())
                .writeBooleanField(ACTIVE, product.getActive())
            .writeEndObject();
    }
}
