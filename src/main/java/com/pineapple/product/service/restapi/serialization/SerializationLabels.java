package com.pineapple.product.service.restapi.serialization;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum SerializationLabels {

    PRODUCT(""),

        ID("id"),
        NAME("name"),
        DESCRIPTION("description"),
        ADDITIONAL_DESCRIPTION("additionalDescription"),
        MODEL("model"),
        PRICE("price"),
        DISCOUNT("discount"),
        WEIGHT("weight"),
        DIMENSIONS("dimensions"),
        PACKING_WEIGHT("packingWeight"),
        PACKING_DIMENSIONS("packingDimensions"),
        ACTIVE("active");

    private final String value;


    @Override
    public String toString() {
        return this.value;
    }
}
