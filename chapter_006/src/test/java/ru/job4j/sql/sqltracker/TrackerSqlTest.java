package ru.job4j.sql.sqltracker;

import org.junit.Test;
import ru.job4j.tracker.Item;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TrackerSqlTest {

    public Connection init() {
        try (InputStream in = TrackerSql.class.getClassLoader().getResourceAsStream("app.properties")) {
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
    public void createItem() throws SQLException {
        TrackerSql trackerSql = new TrackerSql(ConnectionRollback.create(this.init()));
        Item item = new Item("test1", "test2");
        trackerSql.add(item);
        assertThat(trackerSql.findByName("test1").size(), is(1));

    }

    @Test
    public void deleteItem() throws SQLException {
        TrackerSql trackerSql = new TrackerSql(ConnectionRollback.create(this.init()));
        Item item = new Item("delete", "deletedesc");
        Item item2 = new Item("delete2", "deletedesc2");
        String id = trackerSql.add(item).getId();
        trackerSql.add(item2);
        assertThat(trackerSql.delete(id), is(true));
        assertThat(trackerSql.findByName("delete").size(), is(0));
    }

    @Test
    public void replaceItem() throws SQLException {
        TrackerSql tracker = new TrackerSql(ConnectionRollback.create(this.init()));
        Item item = new Item("relace", "replacedesc");
        String id = tracker.add(item).getId();
        tracker.replace(id, new Item("newreplace", "newdescreplace"));
        assertThat(tracker.replace(id, new Item("newreplace", "newdescreplace")), is(true));

    }

    @Test
    public void findAll() throws SQLException {
        TrackerSql trackerSql = new TrackerSql(ConnectionRollback.create(this.init()));
        int size = trackerSql.findAll().size();
        trackerSql.add(new Item("test", "test"));
        assertThat(trackerSql.findAll().size(), is(size + 1));
    }

    @Test
    public void findName() throws SQLException {
        TrackerSql trackerSql = new TrackerSql(ConnectionRollback.create(this.init()));
        Item item = new Item("1", "2");
        trackerSql.add(item);
        assertThat(trackerSql.findByName("1").get(0), is(item));
    }

}