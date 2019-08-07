package ru.job4j.update;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DummyDicTest {

    @Test
    public void engtorus() {
        DummyDic dummyDic = new DummyDic();
        String rs = dummyDic.engtorus("What");
        String expected = "Неизвестное слово: What";
        assertThat(rs, is(expected));
    }
}