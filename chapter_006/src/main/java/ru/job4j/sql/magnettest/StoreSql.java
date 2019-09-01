package ru.job4j.sql.magnettest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.job4j.sql.sqltracker.TrackerSql;

import java.io.InputStream;
import java.sql.*;
import java.util.*;

public class StoreSql implements AutoCloseable {
    private static final Logger LOG = LogManager.getLogger(StoreSql.class.getName());
    private final Config config;
    private Connection connection;

    public StoreSql(Config config) {
        this.config = config;
        this.init();
    }

    /**
     * Генерирует n количество записей в базе
     *
     * @param size - количество данных в базе
     */
    public void generate(int size) {
        String sql = "insert into  acounts(field) values(?) ";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            this.connection.setAutoCommit(false);
            for (int i = 1; i <= size; i++) {
                statement.setInt(1, i);
                statement.addBatch();
            }
            statement.executeBatch();
            this.connection.commit();
        } catch (Exception e) {
            LOG.error("Error in generate() ", e);
            throw new IllegalStateException(e);
        }

    }

    /**
     * Метод загрузки данных в таблицу и возврат коллекции Entry
     *
     * @return Коллекция Entry
     */
    public List<Entry> load() {
        List<Entry> rs = new ArrayList<>();
        String sql = "select * from acounts";
        try (PreparedStatement statement = this.connection.prepareStatement(sql)) {
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                rs.add(new Entry(set.getInt(1)));
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
        check();
        try (InputStream in = TrackerSql.class.getClassLoader().getResourceAsStream("app.properties2")) {
            Properties cfg = new Properties();
            cfg.load(in);
            Class.forName(cfg.getProperty("driver-class-name"));
            String url = cfg.getProperty("url");
            this.connection = DriverManager.getConnection((url), cfg.getProperty("username"), cfg.getProperty("password"));
        } catch (Exception e) {
            throw new IllegalStateException();
        }


        return this.connection != null;
    }

    /**
     * Метод проверяет что есть таблица , и если она существует удаляет и пересоздает ее пустой опреденной структуры.
     */
    private void check() {
        String sqlinit = "create table  main. acounts("
                +
                "field integer )";
        String sqldelete = "drop table if exists acounts";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:memory:", "sqllite", "password")) {
            PreparedStatement statement = connection.prepareStatement(sqldelete);
            statement.execute();
            statement = connection.prepareStatement(sqlinit);
            statement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод закрывает соединение с базой.
     *
     * @throws Exception
     */
    @Override
    public void close() throws Exception {
        if (Objects.nonNull(this.connection)) {
            this.connection.close();
        }

    }


    public static void main(String[] args) {
        StoreSql storeSql = new StoreSql(new Config());
        storeSql.generate(10000);

    }


}
