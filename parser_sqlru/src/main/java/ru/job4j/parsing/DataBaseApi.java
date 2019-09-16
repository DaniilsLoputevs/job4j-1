package ru.job4j.parsing;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.sql.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
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
        this.init();
    }

    /**
     * Метод пакетным способом отправляет полученные данные из парсера в базу данных
     * закрытие ресурсов производится в (try with resources)
     *
     * @param dataTypes Полученные обьекты при парсинге сайта sql.ru
     */

    @Override
    public void insertData(List<? extends DataType> dataTypes) {
        String sql = "insert into sqlru.public.job(name_job, text, url,data_vac) VALUES (?,?,?,?) on conflict do nothing ";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            for (DataType vacancy : dataTypes) {
                statement.setString(1, vacancy.getTitle());
                statement.setString(2, vacancy.getText());
                statement.setString(3, vacancy.getUrl());
                statement.setTimestamp(4, Timestamp.valueOf(vacancy.getTime()));
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            LOG.error("error in insertData()", e);
        }

    }

    /**
     * Получение данных из таблицы (закрытие ресурсов производится в try with resources)
     *
     * @return коллекция обьектов ? extends DataType
     */
    @Override
    public List<? extends DataType> getAllData() {
        List<Vacancy> rs = new ArrayList<>();
        String sql = "select name_job, text, url, data_vac from sqlru.public.job;";
        try (PreparedStatement statement = this.connection.prepareStatement(sql);
             ResultSet set = statement.executeQuery()) {
            while (set.next()) {
                String title = set.getString(1);
                String text = set.getString(2);
                String url = set.getString(3);
                Timestamp time = set.getTimestamp(4);
                rs.add(new Vacancy(url, title, text, time.toLocalDateTime()));


            }
        } catch (SQLException e) {
            LOG.error("error getdata in table0", e);
        }
        return rs;
    }

    @Override
    public List<? extends DataType> findByTitle(String value) {
        List<Vacancy> rs = new ArrayList<>();
        String sql = "select * from sqlru.public.job where name_job = ?;";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setString(1, value);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                Timestamp time = set.getTimestamp("data_vac");
                rs.add(new Vacancy(set.getString(3), set.getString(1), set.getString(2), time.toLocalDateTime()));
            }
            set.close();
        } catch (SQLException e) {
            LOG.error("error in find()", e);
        }
        return rs;
    }

    /**
     * Получение последней добавленной даты из базы данных
     *
     * @return обьект LocalDateTime с последней датой в базе
     */
    public LocalDateTime takeLastDataInDb() {
        LocalDateTime rs = null;
        String sql = "select data_vac from  sqlru.public.job order by data_vac desc limit 1";
        try (PreparedStatement statement = this.connection.prepareStatement(sql);
             ResultSet set = statement.executeQuery()) {
            while (set.next()) {
                rs = set.getTimestamp(1).toLocalDateTime();
            }
        } catch (SQLException e) {
            LOG.error("error takeLastDataInDb()", e);
        }
        return rs;
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
        System.out.println(dataBaseApi.takeLastDataInDb());
        System.out.println(dataBaseApi.findByTitle("Java"));
    }
}
