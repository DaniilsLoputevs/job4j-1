package ru.job4j.sql.parsesqlru;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DataBaseApi {

    private static final Logger LOG = LogManager.getLogger(ParserSqlru.class.getName());
    private Connection connection;
    private boolean exist;

    public DataBaseApi(Connection connection) {
        this.connection = connection;
    }

    public DataBaseApi() {
        this.exist = false;
    }


    /**
     * Метод инициализирует подключение к базе данных
     */
    public void init() {
        this.checkStruct();
        try (InputStream inputStream = DataBaseApi.class.getClassLoader().getResourceAsStream("app.properties3")) {
            Properties properties = new Properties();
            properties.load(inputStream);
            Class.forName(properties.getProperty("driver-class-name"));
            String url = properties.getProperty("url");
            this.connection = DriverManager.getConnection((url), properties.getProperty("username"), properties.getProperty("password"));

        } catch (Exception e) {
            LOG.error("error connect too db", e);
            e.printStackTrace();
        }

    }


    private void checkStruct() {
        String sql = "CREATE TABLE IF NOT EXISTS job("
                +
                "id serial primary key ,"
                +
                "name_job varchar(200)not null ,"
                +
                "text varchar(200)not null ,"
                +
                "url varchar(200));";
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/sqlru", "postgres", "password");
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.execute();

        } catch (Exception e) {
            LOG.error("error check", e);
        }

    }


    public static void main(String[] args) {
        DataBaseApi dataBaseApi = new DataBaseApi();
        dataBaseApi.init();
    }


}
