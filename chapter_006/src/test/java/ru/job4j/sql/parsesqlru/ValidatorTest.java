package ru.job4j.sql.parsesqlru;

import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ValidatorTest {

    @Test
    public void checkKeyWords() {
    }

    @Test
    public void checkConvertTimeWithDifferentView() {
        Validator validator = new Validator();
        String s = "12 сен 19, 20:47";
        String s2 = "сегодня, 20:47";
        String s3 = "вчера, 20:47";
        String s4 = "11 сен 19, 20:47";
        long rsone = validator.convertTime(s);
        long rstwo = validator.convertTime(s2);
        long rsthree = validator.convertTime(s3);
        long rsfour = validator.convertTime(s4);
        assertThat(rsone, is(1568310420000L));
        assertThat(rstwo, is(1568310420000L));
        assertThat(rsthree, is(1568224020000L));
        assertThat(rsthree, is(1568224020000L));
        assertThat(rsfour, is(1568224020000L));
    }
}