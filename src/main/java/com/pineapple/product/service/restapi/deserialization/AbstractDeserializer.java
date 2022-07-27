package com.pineapple.product.service.restapi.deserialization;

import com.pineapple.serialization.AbstractJsonDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Map;

public abstract class AbstractDeserializer<T> extends AbstractJsonDeserializer<T> {

    @Autowired
    private ApplicationContext context;

    public AbstractDeserializer<?> getDeserializer(Class<?> type) {
        return ((Map<Class<?>, AbstractDeserializer<?>>) context.getBean("deserializerMap"))
                .get(type);
    }
}
