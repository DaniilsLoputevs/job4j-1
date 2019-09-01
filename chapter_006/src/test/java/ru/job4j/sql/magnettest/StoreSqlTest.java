package ru.job4j.sql.magnettest;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class StoreSqlTest {

    @Test
    public void generate() {
    }

    @Test
    public void load() {

    }

    @Test
    public void init() {
        StoreSql sql = new StoreSql(new Config());
        assertThat(sql.init(), is(true));
    }

}