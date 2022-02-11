package ru.job4j.tracker;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader()
                .getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenFindAllItems() {
        Store tracker = new SqlTracker(connection);
        Item item1 = tracker.add(new Item("item1"));
        Item item2 = tracker.add(new Item("item2"));
        Item item3 = tracker.add(new Item("item3"));
        Item item4 = tracker.add(new Item("item4"));
        assertThat(tracker.findAll(), is(List.of(item1, item2, item3, item4)));
    }

    @Test
    public void whenDeleteItem() {
        Store tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        assertTrue(tracker.delete(item.getId()));
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindById() {
        Store tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenFindByName() {
        Store tracker = new SqlTracker(connection);
        Item item = tracker.add(new Item("item"));
        Item item2 = tracker.add(new Item("item2"));
        Item item3 = tracker.add(new Item("item"));
        assertThat(tracker.findByName(item.getName()), is(List.of(item, item3)));
    }

    @Test
    public void whenReplaceItem() {
        Store tracker = new SqlTracker(connection);
        Item item = new Item("item");
        Item replacedItem = tracker.add(item);
        item.setName("replaced item");
        tracker.replace(replacedItem.getId(), item);
        assertThat(tracker.findById(item.getId()), is(item));
    }
}