package ru.job4j.storeauto.mapper;


import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.List;

public class DataMapper {
    private static final Gson GSON = new Gson();

    public static <T> void convertModelToJson(HttpServletResponse response, List<T> value) throws IOException {
        GSON.toJson(value, response.getWriter());
    }


    public static <T> T convertJsonToModel(HttpServletRequest request, Class<T> tClass) throws IOException {
        return GSON.fromJson(new JsonReader(new InputStreamReader(request.getInputStream())), tClass);
    }
}
