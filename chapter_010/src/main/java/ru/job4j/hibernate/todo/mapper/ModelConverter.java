package ru.job4j.hibernate.todo.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.hibernate.todo.model.Item;


import java.util.Collection;


public class ModelConverter {


    public static String convertModelToJson(Collection<Item> item) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        StringBuffer stringBuffer = new StringBuffer();
        for (Item value : item) {
            stringBuffer.append(objectMapper.writeValueAsString(value));
        }
        return stringBuffer.toString();
    }

    public static Item convertJsontoModel(String request) {
        Item item = null;
        return item;
    }

}
