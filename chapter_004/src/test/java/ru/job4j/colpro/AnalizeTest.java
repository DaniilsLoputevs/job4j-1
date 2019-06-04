package ru.job4j.colpro;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AnalizeTest {
    public List<User> prev;
    public List<User> next;
    Analize analize;

    @Before
    public void init() {
        analize = new Analize();
        prev = new ArrayList<>();
        next = new ArrayList<>();
        prev.add(new User("24", "ABC"));
        prev.add(new User("25", "EFG"));
        next.add(new User("24", "ABC"));
        next.add(new User("25", "ABCD"));
        next.add(new User("26", "XYZ"));

    }

    @Test
    public void diffCheckAddedAndChanchedNext() {
        Analize.Info test = new Analize.Info(1, 1, 0);
        Analize.Info rs = analize.diff(prev, next);
        assertEquals(test, rs);
    }

    @Test
    public void diffCheckDelete() {
        Analize.Info test = new Analize.Info(1, 1, 1);
        next.remove(0);
        Analize.Info rs = analize.diff(prev, next);
        assertEquals(test, rs);
    }
}