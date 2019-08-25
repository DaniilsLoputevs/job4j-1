package ru.job4j.sql.sqltracker;

import ru.job4j.tracker.ItTracker;
import ru.job4j.tracker.Item;


import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

public class TrackerSql implements ItTracker, AutoCloseable {
    private Connection connection;


    @Override
    public void close() throws Exception {
        close();
    }

    @Override
    public Item add(Item item) {
        try (Connection connectionadd = this.connection) {
            String sql = "insert into tracker.public.items(name, description,created) values(?,?,?) ";
            PreparedStatement statement = connectionadd.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, item.getName());
            statement.setString(2, item.getDesc());
            statement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
            statement.executeUpdate();
            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    item.setId(keys.getString(1));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<Item> findAll() {
        return null;
    }

    @Override
    public List<Item> findByName(String name) {
        return null;
    }

    @Override
    public Item findById(String id) {
        return null;
    }


    public boolean init() {
        try (InputStream in = TrackerSql.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties cfg = new Properties();
            cfg.load(in);
            Class.forName(cfg.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(cfg.getProperty("url"), cfg.getProperty("username"), cfg.getProperty("password"));
            CheckerDB.checkDb();
        } catch (Exception e) {
            throw new IllegalStateException();
        }


        return this.connection != null;
    }


    private static class CheckerDB {

        private static void checkDb() throws SQLException {
            try (Connection connection1 = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/tracker", "postgres", "password");) {
                Statement st = connection1.createStatement();
                st.execute("create table if not exists items ("
                        +
                        "id serial primary key ,"
                        +
                        "name varchar (200) not null ,"
                        +
                        "description varchar (200),"
                        +
                        "created timestamp ,"
                        +
                        "comments varchar (1000));");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        TrackerSql trackerSql = new TrackerSql();
        trackerSql.init();
        System.out.println(trackerSql.add(new Item("test", "desct", 454564)));
    }
}
