package ru.job4j.hibernate.todo.mapper;


import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.hibernate.todo.model.Item;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collection;

/**
 * Converting JSON to Model and Model to Json
 * @see  //github.com/FasterXML/jackson
 */
public class ModelConverter {
    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    public static void convertModelToJson(HttpServletResponse response, Collection<Item> item) throws Exception {
        OBJECT_MAPPER.writeValue(response.getWriter(), item);
    }

    public static Item convertJsontoModel(HttpServletRequest request) throws IOException {
        Item item = new Item();
        item = OBJECT_MAPPER.readValue(request.getInputStream(), Item.class);
        return item;
    }

}
