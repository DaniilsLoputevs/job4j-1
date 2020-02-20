package ru.job4j.spring;


import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;


@Component
public class Hsqldb implements DbInterface {
    private final BasicDataSource dataSource = new BasicDataSource();


    @Autowired
    public Hsqldb() {
        dataSource.setUrl("jdbc:hsqldb:mem:users_test");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
        init();
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    private void init() {
        try {
            Connection connection = dataSource.getConnection();
            connection.prepareStatement("create table users_table ("
                    +
                    "id identity primary key ,"
                    +
                    "name varchar (200))").execute();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
