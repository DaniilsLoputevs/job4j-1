package ru.job4j.parsing;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DataBaseApiTest {

    public Connection init() {
        try (InputStream in = DataBaseApi.class.getClassLoader().getResourceAsStream("app.properties3")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void insertData() throws SQLException {
        ValidatorSqlru validatorSqlru = new ValidatorSqlru();
        LocalDateTime localDateTime = validatorSqlru.convertTime("сегодня, 22:43");
        Vacancy vacancy = new Vacancy("testurl", "testtitle", "testtext", localDateTime);
        List<Vacancy> in = new ArrayList<>();
        in.add(vacancy);
        DataBaseApi dataBaseApi = new DataBaseApi(ConnectionRollBack.create(this.init()));
        dataBaseApi.insertData(in);
        assertThat(dataBaseApi.findByTitle("testtitle").size(), is(1));
    }

}