package ru.job4j.sql.parsesqlru;


import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
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

    /**
     * Метод парсит дату и преобразовывает его в long представление , используется DateTimeFormatter с custom паттернами разбора строки.
     *
     * @param time строковое представление даты
     * @return long значение полученное
     */

    public long convertTime(String time) {
        DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder().appendPattern("d ").appendText(ChronoField.MONTH_OF_YEAR, this.moth).appendPattern(" yy, H:mm").toFormatter();
        Long value = 0L;
        LocalDateTime parse = LocalDateTime.parse(time, dateTimeFormatter);
        value = Timestamp.valueOf(parse).getTime();


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

    public static void main(String[] args) {
        Validator validator = new Validator();
        validator.convertTime("1 сен 19, 17:25");

    }
}
