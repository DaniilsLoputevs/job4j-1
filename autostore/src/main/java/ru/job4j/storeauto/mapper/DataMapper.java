package ru.job4j.storeauto.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.storeauto.models.Account;
import ru.job4j.storeauto.models.Advert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class DataMapper {
    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static <T> void convertModelToJson(HttpServletResponse response, List<T> value) throws IOException {
        OBJECT_MAPPER.writeValue(response.getWriter(), value);

    }

    public static <T> T convertJsonToModel(HttpServletRequest request, Class<T> tClass) throws IOException {
        return OBJECT_MAPPER.readValue(request.getInputStream(), tClass);
    }
}