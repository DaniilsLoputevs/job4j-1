package ru.job4j.sql.sqltracker;

import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TrackerSqlTest {

    @Test
    public void init() {
        TrackerSql trackerSql = new TrackerSql();
        assertThat(trackerSql.init(), is(true));
    }
}