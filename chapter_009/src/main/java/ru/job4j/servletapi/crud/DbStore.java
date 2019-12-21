package ru.job4j.servletapi.crud;

import org.apache.commons.dbcp2.BasicDataSource;


import java.io.InputStream;
import java.sql.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

public class DbStore implements Store {
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static final DbStore INSTANCE = new DbStore();

    private DbStore() {
        Properties properties = initprop();
        SOURCE.setUrl(properties.getProperty("url"));
        SOURCE.setDriverClassName(properties.getProperty("driver-class-name"));
        SOURCE.setUsername(properties.getProperty("username"));
        SOURCE.setPassword(properties.getProperty("password"));
        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
        checkdb();
    }

    public static DbStore getinstance() {
        return INSTANCE;
    }

    /**
     * Метод добавляет пользователя в базу данных
     *
     * @param user добавляемый обьект класса User
     */
    @Override
    public void add(User user) {
        try (Connection connection = SOURCE.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("insert into users_servlets.public.users_servlets(name, login, email, created) values (?,?,?,?)");
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getEmail());
            statement.setTimestamp(4, Timestamp.valueOf(user.getLocalDateTime()));
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Метод производит изменения в базе данных по id
     *
     * @param id   ID пользователя
     * @param user Обновленные данные
     * @return true/false значение в зависимости от результата работы
     */
    @Override
    public boolean update(String id, User user) {
        boolean rs = false;
        try (Connection connection = SOURCE.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("update users_servlets.public.users_servlets set name = ?, login = ?, email=? where id = ?");
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getEmail());
            statement.setInt(4, Integer.parseInt(id));
            rs = statement.execute();
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * Метод удаляет из базы данных по id
     *
     * @param user удаляемый обьект  ( используется id пользователя)
     * @return результат удаления true/false
     */
    @Override
    public boolean delete(User user) {
        boolean rs = false;
        try (Connection connection = SOURCE.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("delete from users_servlets.public.users_servlets where id = ?");
            statement.setInt(1, Integer.parseInt(user.getId()));
            rs = statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    @Override
    public User findById(String id) {
        User user = null;
        try (Connection connection = SOURCE.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select id, name, login, email, created from users_servlets.public.users_servlets where id =?");
            statement.setInt(1, Integer.parseInt(id));
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                user = new User(set.getString("id"), set.getString("name"), set.getString("login"), set.getString("email"), set.getTimestamp("created").toLocalDateTime());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * Метод производит запрос к базе данных и получает всех пользователей
     *
     * @return Collection<User>
     */
    @Override
    public Collection<User> findAll() {
        Collection<User> rs = new ArrayList<>();
        try (Connection connection = SOURCE.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select id, name, login, email, created from users_servlets.public.users_servlets");
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                String id = set.getString(1);
                String name = set.getString(2);
                String login = set.getString(3);
                String email = set.getString(4);
                Timestamp timestamp = set.getTimestamp(5);
                rs.add(new User(id, name, login, email, timestamp.toLocalDateTime()));
            }
            set.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * Утилитный метод возвращающий Properties с настройками к базе данных.
     *
     * @return
     */
    private Properties initprop() {
        Properties properties = new Properties();
        try (InputStream inputStream = DbStore.class.getClassLoader().getResourceAsStream("app.properties")) {
            properties.load(inputStream);
            Class.forName(properties.getProperty("driver-class-name"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    /**
     * Утилитный метод проверяющий структуру в базе данных на наличие таблицы.
     */
    private void checkdb() {
        try (Connection connection = SOURCE.getConnection()) {
            Statement statement = connection.createStatement();
            statement.execute("create table if not exists users_servlets("
                    +
                    "id serial primary key,"
                    +
                    "name varchar(200)not null,"
                    +
                    "login varchar(200) not null,"
                    +
                    "password varchar(13)not null, "
                    +
                    "email varchar(200) not null ,"
                    +
                    "created timestamp);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean userExist(String login, String password) {
        boolean rs = false;
        try (Connection connection = SOURCE.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select login,password from users_servlets.public.users_servlets where login =? and password = ?");
            statement.setString(1, login);
            statement.setString(2, password);
            ResultSet s = statement.executeQuery();
            while (s.next()) {
                String resultlogin = s.getString("login");
                String resultpassword = s.getString("password");
                if (resultlogin.equals(login) && resultpassword.equals(password)) {
                    rs = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
