package com.pineapple.product.service.infra.config;

import com.pineapple.product.service.restapi.deserialization.AbstractDeserializer;
import com.pineapple.product.service.restapi.serialization.AbstractSerializer;
import com.pineapple.product.service.restapi.wrapper.ProductWrapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class SerializationConfig {

    @Bean
    public Map<Class<?>, AbstractSerializer<?>> serializerMap(
            @Qualifier("productSerializer") AbstractSerializer<?> productSerializer) {
        return new HashMap<>() {{
            put(ProductWrapper.class, productSerializer);
        }};
    }

    @Bean
    public Map<Class<?>, AbstractDeserializer<?>> deserializerMap(
            @Qualifier("productDeserializer") AbstractDeserializer<?> productDeserializer) {
        return new HashMap<>() {{
            put(ProductWrapper.class, productDeserializer);
        }};
    }
}
