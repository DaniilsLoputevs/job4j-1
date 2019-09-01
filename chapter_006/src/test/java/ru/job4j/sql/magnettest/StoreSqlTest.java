package ru.job4j.sql.magnettest;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class StoreSqlTest {


    @Test
    public void initCheckLoadCheckAndGenerate() {
        StoreSql sql = new StoreSql(new Config());
        sql.generate(2);
        List<Entry> rs = sql.load();
        List<Entry> exp = new ArrayList<>();
        exp.add(new Entry(1));
        exp.add(new Entry(2));
        assertThat(rs.equals(exp), is(true));
        assertThat(rs.size(), is(2));

    }

}