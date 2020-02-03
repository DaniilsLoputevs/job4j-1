package ru.job4j.storeauto.mapper;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


import java.util.List;

public class DataMapper {
    private static Hibernate5Module hibernateModule = new Hibernate5Module();
    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * pre init hiber5Module for custom serialization data
     * @see  https://mvnrepository.com/artifact/com.fasterxml.jackson.datatype/jackson-datatype-hibernate5
     */
    static {
        hibernateModule.enable(Hibernate5Module.Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS);
        mapper.registerModule(hibernateModule);
    }

    /**
     * Convert model to JSON and write data on response . use generic type
     *
     * @param response servlet response
     * @param value    converting value
     * @param <T>      generic type
     * @throws IOException
     */
    public static <T> void convertModelToJson(HttpServletResponse response, List<T> value) throws IOException {
        mapper.writeValue(response.getWriter(), value);
    }

    /**
     * Convert JSON data to model , use generic type
     *
     * @param request servlet request
     * @param tClass  generic class type
     * @param <T>     return value
     * @return result after mapper convert data to model
     * @throws IOException
     */
    public static <T> T convertJsonToModel(HttpServletRequest request, Class<T> tClass) throws IOException {
        return mapper.readValue(request.getInputStream(), tClass);
    }

}
