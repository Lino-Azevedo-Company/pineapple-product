package com.pineapple.product.service.restapi.deserialization;

import com.fasterxml.jackson.databind.JsonNode;
import com.pineapple.product.service.infra.exception.InvalidJsonException;
import com.pineapple.product.service.restapi.serialization.SerializationLabels;
import com.pineapple.product.service.restapi.wrapper.ListWrapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.LinkedList;

@Component
public class ListWrapperDeserializer<T> extends AbstractDeserializer<ListWrapper<?>> {

    @Override
    public ListWrapper<T> deserialize(JsonNode node) throws IOException {
        throw new UnsupportedOperationException("É necessário saber o tipo");
    }

    public <T> ListWrapper<T> deserialize(JsonNode node, final Class<T> tClass) throws IOException {
        try {
            var deserializer = (AbstractDeserializer<T>) getDeserializer(tClass);
            var items = new LinkedList<T>();
            if (node != null) {
                for (var nodeObject : node) {
                    T item = deserializer.deserialize(nodeObject);
                    items.add(item);
                }
            }
            return new ListWrapper<>(items);
        } catch (RuntimeException e) {
            throw new InvalidJsonException("Json inválido: " + e, e);
        }
    }

    public <T> ListWrapper<T> deserialize(JsonNode node,
                                          SerializationLabels name,
                                          Class<T> tClass) throws IOException {
        return node.has(name.toString()) ?
                deserialize(node.get(name.toString()), tClass) :
                new ListWrapper<>();
    }
}
