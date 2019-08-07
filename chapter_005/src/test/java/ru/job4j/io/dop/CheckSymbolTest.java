package ru.job4j.io.dop;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CheckSymbolTest {

    @Test
    public void checkTwoArraysStringThenReturnFalse() {
        CheckSymbol checkSymbol = new CheckSymbol();
        String[] f = new String[]{"a", "b", "v", "f"};
        String[] s = new String[]{"b", "v", "a", "n"};
        boolean rs = checkSymbol.checkArrays(f, s);
        assertThat(rs, is(false));
    }

    @Test
    public void checkTwoArraysStringThenReturnFalse2() {
        CheckSymbol checkSymbol = new CheckSymbol();
        String[] f = new String[]{"a", "b", "v", "f"};
        String[] s = new String[]{"b", "v", "a"};
        boolean rs = checkSymbol.checkArrays(f, s);
        assertThat(rs, is(false));
    }

    @Test
    public void checkTwoArraysStringThenReturnTrue() {
        CheckSymbol checkSymbol = new CheckSymbol();
        String[] f = new String[]{"a", "b", "v", "n"};
        String[] s = new String[]{"b", "v", "a", "n"};
        boolean rs = checkSymbol.checkArrays(f, s);
        assertThat(rs, is(true));
    }

    @Test
    public void charArraysCheckAndReturnTrue() {
        CheckSymbol checkSymbol = new CheckSymbol();
        char[] d = new char[]{'a', 'b', 'v', 'n'};
        char[] y = new char[]{'b', 'v', 'a', 'n'};
        boolean rs = checkSymbol.checkArrays(d, y);
        assertThat(rs, is(true));

    }

    @Test
    public void charArraysCheckAndReturnFalse() {
        CheckSymbol checkSymbol = new CheckSymbol();
        char[] d = new char[]{'a', 'b', 'v', 'n'};
        char[] y = new char[]{'b', 'v', 'a', 'f'};
        boolean rs = checkSymbol.checkArrays(d, y);
        assertThat(rs, is(false));

    }

    @Test
    public void checkArraysCharAndReturnFalse() {
        CheckSymbol checkSymbol = new CheckSymbol();
        char[] d = new char[]{'a', 'b', 'v', 'n'};
        char[] y = new char[]{'b', 'v', 'a'};
        boolean rs = checkSymbol.checkArrays(d, y);
        assertThat(rs, is(false));

    }

    @Test
    public void checkArraysCharAndReturnTrue2() {
        CheckSymbol checkSymbol = new CheckSymbol();
        char[] d = new char[]{'a', 'n', 'n', 'a'};
        char[] y = new char[]{'n', 'n', 'a', 'a'};
        boolean rs = checkSymbol.checkArrays(d, y);
        assertThat(rs, is(true));
    }
}