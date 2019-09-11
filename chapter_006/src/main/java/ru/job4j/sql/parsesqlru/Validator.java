package ru.job4j.sql.parsesqlru;


import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.*;

public class Validator {
    private Map<Long, String> moth;

    public Validator() {
        this.moth = new HashMap<>();
        this.initvalMoth();
    }


    public static boolean checkTitle(String title) {
        String unvalidate = "Script";

        boolean rs = false;
        if (!title.contains(unvalidate)) {
            rs = true;

        }
        return rs;
    }


    public long convertTime(String time) throws ParseException {
        DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder().appendPattern("d").appendText(ChronoField.MONTH_OF_YEAR, this.moth).appendPattern("yy").toFormatter();
        Long value = 0L;
        if (time.contains("сен")) {
            LocalDate parse = LocalDate.parse(time, dateTimeFormatter);
            System.out.println(parse);
            String s = parse.toString();
            System.out.println(s);
        }

        return value;

    }

    private void initvalMoth() {
        this.moth.put(1L, "янв");
        this.moth.put(2L, "фев");
        this.moth.put(3L, "мар");
        this.moth.put(4L, "апр");
        this.moth.put(5L, "май");
        this.moth.put(6L, "июн");
        this.moth.put(7L, "июл");
        this.moth.put(8L, "авг");
        this.moth.put(9L, "сен");
        this.moth.put(10L, "окт");
        this.moth.put(11L, "дек");
    }

    public static void main(String[] args) throws ParseException {
        Validator validator = new Validator();
        validator.convertTime("02-дек-15");

    }
}
