package ru.job4j.servletapi.crud.store;

import org.apache.commons.dbcp2.BasicDataSource;
import ru.job4j.servletapi.crud.models.Role;
import ru.job4j.servletapi.crud.models.User;


import java.io.InputStream;
import java.sql.*;

import java.time.LocalDateTime;
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
            PreparedStatement statement = connection.prepareStatement("insert into users_servlets.public.users(name, login,password, email, created,role) values (?,?,?,?,?,?)");
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getEmail());
            statement.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
            statement.setString(6, user.getRole().name());
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
            PreparedStatement statement = connection.prepareStatement("update users_servlets.public.users set name = ?, login = ?, email=? where id = ?");
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
            PreparedStatement statement = connection.prepareStatement("delete from users_servlets.public.users where id = ?");
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
            PreparedStatement statement = connection.prepareStatement("select id, name, login, email, created,role from users_servlets.public.users where id =?");
            statement.setInt(1, Integer.parseInt(id));
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                String userid = set.getString("id");
                String name = set.getString("name");
                String login = set.getString("login");
                String email = set.getString("email");
                Timestamp created = set.getTimestamp("created");

                user = new User(userid, name, login, email, created.toLocalDateTime(), Role.USER);
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
            PreparedStatement statement = connection.prepareStatement("select id, name, login, email, created,role from users_servlets.public.users");
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                String id = set.getString(1);
                String name = set.getString(2);
                String login = set.getString(3);
                String email = set.getString(4);
                Timestamp timestamp = set.getTimestamp(5);
                String role = set.getString(6);
                rs.add(new User(id, name, login, email, timestamp.toLocalDateTime(), Role.valueOf(role)));
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
            Statement statement1 = connection.createStatement();
            statement1.execute("create table if not exists users("
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
                    "role varchar(10) not null ,"
                    +
                    "created timestamp);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean userExist(String login, String password) {
        boolean rs = false;
        try (Connection connection = SOURCE.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select login,password from users_servlets.public.users where login =? and password = ?");
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


    public String getRole(String login) {
        String rs = null;
        try (Connection connection = SOURCE.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("select role from users_servlets.public.users where login = ?");
            statement.setString(1, login);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                rs = set.getString("role");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }


}
