package ru.job4j.sql.magnettest;

import java.io.File;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StoreSql implements AutoCloseable {

    private final Config config;
    private Connection connection;

    public StoreSql(Config config) {
        this.config = config;
    }

    /**
     * Генерирует n количество записей в базе
     *
     * @param size - количество данных в базе
     */
    public void generate(int size) {

    }

    public List<Entry> load() {
        List<Entry> rs = new ArrayList<>();
        return rs;
    }


    public void checkDb() {
        String url = config.get("url");
        try (Connection connection = DriverManager.getConnection(url)) {
            if (Objects.nonNull(connection)) {
                DatabaseMetaData metaData = connection.getMetaData();
                System.out.println(metaData.getDriverName());


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void close() throws Exception {
        if (Objects.nonNull(this.connection)) {
            this.connection.close();
        }

    }


}
