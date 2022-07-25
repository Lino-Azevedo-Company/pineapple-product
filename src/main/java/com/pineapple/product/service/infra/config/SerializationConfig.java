package com.pineapple.product.service.infra.config;

import com.pineapple.product.service.restapi.deserialization.AbstractJsonDeserializer;
import com.pineapple.product.service.restapi.serialization.AbstractJsonSerializer;
import com.pineapple.product.service.restapi.wrapper.ProductWrapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SerializationConfig {

    @Bean
    public Map<Class<?>, AbstractJsonSerializer<?>> serializerMap(
            @Qualifier("productSerializer") AbstractJsonSerializer<?> productSerializer) {
        return new HashMap<>() {{
            put(ProductWrapper.class, productSerializer);
        }};
    }

    @Bean
    public Map<Class<?>, AbstractJsonDeserializer<?>> deserializerMap(
            @Qualifier("productDeserializer") AbstractJsonDeserializer<?> productDeserializer) {
        return new HashMap<>() {{
            put(ProductWrapper.class, productDeserializer);
        }};
    }
}
