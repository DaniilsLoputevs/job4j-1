package ru.job4j.sql.parsesqlru;

import org.junit.Test;


import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ValidatorSqlruTest {

    @Test
    public void checkKeyWords() {
    }

    @Test
    public void checkConvertTimeWithDifferentView() {
        ValidatorSqlru validatorSqlru = new ValidatorSqlru();
        LocalDateTime res = validatorSqlru.convertTime("12 сен 19, 21:29");
        LocalDateTime resone = validatorSqlru.convertTime("сегодня, 21:29");
        LocalDateTime exp = LocalDateTime.of(2019, 9, 12, 21, 29);
        LocalDateTime exptwo = LocalDateTime.of(2019, 9, 12, 21, 29);
        assertThat(res, is(exp));
        assertThat(resone, is(exptwo));

    }
}