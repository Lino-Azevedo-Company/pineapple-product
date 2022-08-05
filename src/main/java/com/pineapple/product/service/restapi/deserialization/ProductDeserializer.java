package com.pineapple.product.service.restapi.deserialization;

import com.fasterxml.jackson.databind.JsonNode;
import com.pineapple.product.service.domain.product.Product;
import com.pineapple.product.service.restapi.wrapper.ProductWrapper;
import com.pineapple.commons.serialization.deserialize.AbstractJsonDeserializer;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.pineapple.product.service.restapi.serialization.SerializationLabels.*;

@Component
public class ProductDeserializer extends AbstractJsonDeserializer<ProductWrapper> {

    @Override
    public ProductWrapper deserialize(JsonNode node) throws IOException {
        var product = Product.builder()
                .id(getLongFieldValue(node, ID))
                .name(getStringFieldValue(node, NAME))
                .description(getStringFieldValue(node, DESCRIPTION))
                .additionalDescription(getStringFieldValue(node, ADDITIONAL_DESCRIPTION))
                .model(getStringFieldValue(node, MODEL))
                .price(getBigDecimalFieldValue(node, PRICE))
                .discount(getBigDecimalFieldValue(node, DISCOUNT))
                .weight(getBigDecimalFieldValue(node, WEIGHT))
                .dimensions(getStringFieldValue(node, DIMENSIONS))
                .packingWeight(getBigDecimalFieldValue(node, PACKING_WEIGHT))
                .packingDimensions(getStringFieldValue(node, PACKING_DIMENSIONS))
                .active(getBooleanFieldValue(node, ACTIVE))
                .build();
        return new ProductWrapper(product);
    }
}
