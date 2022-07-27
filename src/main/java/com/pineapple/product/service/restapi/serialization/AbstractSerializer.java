package com.pineapple.product.service.restapi.serialization;

import com.pineapple.serialization.AbstractJsonSerializer;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.util.Map;

@NoArgsConstructor
public abstract class AbstractSerializer<T> extends AbstractJsonSerializer<T> {

    @Autowired
    private ApplicationContext context;

    public AbstractSerializer<?> getSerializer(Class<?> type) {
        return ((Map<Class<?>, AbstractSerializer<?>>) context.getBean("serializerMap"))
                .get(type);
    }

}
