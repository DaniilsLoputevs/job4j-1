package ru.job4j.parsing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DataBaseApi implements DataBaseUsage {

    private static final Logger LOG = LogManager.getLogger(ParserSqlru.class.getName());
    private Connection connection;

    public DataBaseApi(Connection connection) {
        this.connection = connection;
    }

    public DataBaseApi() {
    }


    @Override
    public void insertData(List<? extends DataType> dataTypes) {
        String sql = "insert into sqlru.public.job(name_job, text, url,data_vac) VALUES (?,?,?,?) on conflict do nothing ";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            for (DataType vacancy : dataTypes) {
                Timestamp.valueOf(vacancy.getTime());
                statement.setString(1, vacancy.getTitle());
                statement.setString(2, vacancy.getText());
                statement.setString(3, vacancy.getUrl());
                statement.setTimestamp(4, Timestamp.valueOf(vacancy.getTime()));
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            LOG.error("error in insertData()", e);
        }

    }

    @Override
    public List<? extends DataType> getData() {
        return null;
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
                "name_job VARCHAR(10000)NOT NULL,"
                +
                "text VARCHAR(10000)NOT NULL,"
                +
                "url VARCHAR(200) unique ,"
                +
                "data_vac TIMESTAMP)";
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
        LocalDateTime localDateTime = LocalDateTime.now();
        List<Vacancy> vacancies = new ArrayList<>();
        vacancies.add(new Vacancy("21321312", "описание вакансии", "вакансия", localDateTime));
        dataBaseApi.insertData(vacancies);
    }


}
