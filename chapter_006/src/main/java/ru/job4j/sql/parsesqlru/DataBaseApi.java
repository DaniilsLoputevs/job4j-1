package ru.job4j.sql.parsesqlru;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DataBaseApi {

    private static final Logger LOG = LogManager.getLogger(ParserSqlru.class.getName());
    private Connection connection;

    public DataBaseApi(Connection connection) {
        this.connection = connection;
    }

    public DataBaseApi() {

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
                "id SERIAL PRIMARY KEY,"
                +
                "name_job VARCHAR(200)NOT NULL,"
                +
                "text VARCHAR(200)NOT NULL,"
                +
                "url VARCHAR(200) unique );";
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
