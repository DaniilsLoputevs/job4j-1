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

    public TrackerSql(Connection connection) {
        this.connection = connection;
    }

    public TrackerSql() {
    }


    @Override
    public void close() throws Exception {
        this.connection.close();
    }

    /**
     * Метод обращается к базе данных вставляя данные из подаваемого обьекта item
     *
     * @param item обьект класса Item
     * @return обьект добавленный в базу данных.
     */
    @Override
    public Item add(Item item) {
        String sql = "insert into tracker.public.items(name, description,created) values(?,?,?) ";
        try (PreparedStatement statement = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            statement.setString(1, item.getName());
            statement.setString(2, item.getDesc());
            statement.setTimestamp(3, timestamp);
            item.setCreated(timestamp.getTime());
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

    /**
     * Метод замены данных в базе данных если найден id.
     *
     * @param id   ID искомого обьекта для изменения
     * @param item обьект с изменениями.
     * @return true/false результат изменения.
     */

    @Override
    public boolean replace(String id, Item item) {
        boolean rs = false;
        String sql = "update tracker.public.items set name = ?, description = ? , created = ? where id = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setString(1, item.getName());
            statement.setString(2, item.getDesc());
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            statement.setTimestamp(3, timestamp);
            statement.setInt(4, Integer.parseInt(id));
            rs = statement.executeUpdate() != 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * Метод удаляет данные из базы согласно id
     *
     * @param id идентификатор обьекта Item
     * @return true/false результат удаления
     */
    @Override
    public boolean delete(String id) {
        boolean rs = false;
        String sql = "delete from tracker.public.items where id =?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setInt(1, Integer.parseInt(id));
            int delrow = statement.executeUpdate();
            rs = delrow == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * Метод добавляет в коллекцию List<Item> все записи из таблицы.
     *
     * @return Список всех обьектов Item.
     */
    @Override
    public List<Item> findAll() {
        List<Item> rs = new ArrayList<>();
        String sql = "select * from tracker.public.items";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
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

    /**
     * Метод ищет в базе все обьекты Item с определенным именем.
     *
     * @param name Искомое имя.
     * @return Список найденных обьектов Item.
     */
    @Override
    public List<Item> findByName(String name) {
        List<Item> rs = new ArrayList<>();
        String sql = "select * from tracker.public.items where name = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Timestamp timestamp = resultSet.getTimestamp("created");
                rs.add(new Item(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("description"), timestamp.getTime()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * Метод ищет в базе запись по ID (только численный литерал)
     *
     * @param id ID обьекта Item который требуется найти
     * @return найденный обьект Item
     */
    @Override
    public Item findById(String id) {
        Item rs = null;
        String sql = "select * from tracker.public.items where id = ?";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.setInt(1, Integer.parseInt(id));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Timestamp timestamp = resultSet.getTimestamp("created");
                rs = new Item(resultSet.getString("id"), resultSet.getString("name"), resultSet.getString("description"), timestamp.getTime());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * Инициализирующий метод
     *
     * @return
     */

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

    public void droptable() {
        String sql = "drop table tracker.public.items";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        try (TrackerSql trackerSql = new TrackerSql()) {
            trackerSql.init();
            trackerSql.add(new Item("Test2", "Testdesc2"));
            trackerSql.add(new Item("Test3", "Testdesc3"));
            trackerSql.findById("1");
            trackerSql.findAll();
            trackerSql.findByName("Test1");
            trackerSql.delete("1");
            trackerSql.replace("2", new Item("Replace", "ReplaceDesc"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
