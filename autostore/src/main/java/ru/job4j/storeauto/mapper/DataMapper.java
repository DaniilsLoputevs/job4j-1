package ru.job4j.storeauto.mapper;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import ru.job4j.storeauto.models.Advert;
import ru.job4j.storeauto.models.Car;
import ru.job4j.storeauto.models.CarBody;
import ru.job4j.storeauto.models.Photo;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    public static Advert convertReqDataToModel(HttpServletRequest request) {
        Advert rs = new Advert();
        rs.setTitle(request.getParameter("advert_title"));
        rs.setPrice(request.getParameter("sell_price"));
        rs.setCar(new Car(request.getParameter("car_title"), request.getParameter("car_vincode"), CarBody.valueOf(request.getParameter("car_body"))));
        return rs;
    }

    public static Photo fileOfPartRequest(HttpServletRequest request) throws IOException, ServletException {
        Photo photo = new Photo();
        if (Objects.nonNull(request.getPart("atach"))) {
            Part part = request.getPart("atach");
            File file = new File(System.getProperty("java.io.tmpdir"), File.separator + "images");
            File uploaded = new File(file, File.separator + part.getSubmittedFileName());
            try (FileOutputStream fileOutputStream = new FileOutputStream(uploaded)) {
                uploaded.createNewFile();
                byte[] data = part.getInputStream().readAllBytes();
                fileOutputStream.write(data);
                photo.setPath(uploaded.getAbsolutePath());
                photo.setFilename(uploaded.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return photo;

    }

}
