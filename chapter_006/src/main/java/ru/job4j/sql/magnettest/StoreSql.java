package ru.job4j.sql.magnettest;

import ru.job4j.sql.sqltracker.TrackerSql;

import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class StoreSql implements AutoCloseable {

    private final Config config;
    private Connection connection;

    public StoreSql(Config config) {
        this.config = config;
        this.init();
    }

//    /**
//     * Генерирует n количество записей в базе
//     *
//     * @param size - количество данных в базе
//     */
//    public void generate(int size) {
//        try (PreparedStatement statement = this.connection.prepareStatement()) {
//            statement.execute();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

    public List<Entry> load() {
        List<Entry> rs = new ArrayList<>();
        return rs;
    }


    /**
     * Инициализирующий метод
     *
     * @return
     */

    public boolean init() {
        check();
        try (InputStream in = TrackerSql.class.getClassLoader().getResourceAsStream("app.properties2")) {
            Properties cfg = new Properties();
            cfg.load(in);
            Class.forName(cfg.getProperty("driver-class-name"));
            String url = cfg.getProperty("url") + File.separator + "xml.db";
            this.connection = DriverManager.getConnection((url), cfg.getProperty("username"), cfg.getProperty("password"));
        } catch (Exception e) {
            throw new IllegalStateException();
        }


        return this.connection != null;
    }

    /**
     * Метод проверяет что есть таблица , и если она существует удаляет и пересоздает ее пустой опреденной структуры.
     */
    private void check() {
        String sqlinit = "create table  main. acounts("
                +
                "integer field)";
        String sqldelete = "drop table if exists acounts";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:/home/eveletspb/xml.db", "sqllite", "password")) {
            PreparedStatement statement = connection.prepareStatement(sqldelete);
            statement.execute();
            statement = connection.prepareStatement(sqlinit);
            statement.execute();

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


    public static void main(String[] args) {
        StoreSql storeSql = new StoreSql(new Config());
    }


}
