package ru.job4j.sql.sqltracker;

import ru.job4j.tracker.ItTracker;
import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
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
        this.init();
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
        boolean rs = false;
        this.init();
        try (Connection connectionrep = this.connection) {
            String sql = "update tracker.public.items set name = ?, description = ? , created = ? where id = ?";
            PreparedStatement statement = connectionrep.prepareStatement(sql);
            statement.setString(1, item.getName());
            statement.setString(2, item.getDesc());
            statement.setTimestamp(3, new Timestamp(item.getCreated()));
            statement.setInt(4, Integer.parseInt(id));
            int modifiedrow = statement.executeUpdate();
            rs = modifiedrow == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean delete(String id) {
        boolean rs = false;
        this.init();
        try (Connection connectiondel = this.connection) {
            String sql = "delete from tracker.public.items where id =?";
            PreparedStatement statement = connectiondel.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(id));
            int delrow = statement.executeUpdate();
            rs = delrow == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public List<Item> findAll() {
        List<Item> rs = new ArrayList<>();
        this.init();
        try (Connection connectionfind = this.connection) {
            String sql = "select * from tracker.public.items";
            PreparedStatement statement = connectionfind.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                String desc = resultSet.getString("description");
                Timestamp timestamp = resultSet.getTimestamp("created");
                rs.add(new Item(id, name, desc, timestamp.getTime()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public List<Item> findByName(String name) {
        List<Item> rs = new ArrayList<>();
        this.init();
        try (Connection connectionfindByname = this.connection) {
            String sql = "select * from tracker.public.items where name = ?";
            PreparedStatement statement = connectionfindByname.prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
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
        System.out.println(trackerSql.add(new Item("item31", "desc3")));
        System.out.println(trackerSql.add(new Item("item32", "desc3")));
        System.out.println(trackerSql.add(new Item("item33", "desc3")));
        trackerSql.findAll();
    }
}
