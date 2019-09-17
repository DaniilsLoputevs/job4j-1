package ru.job4j.parsing;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.*;

public class ValidatorSqlru implements ValidateSearching, Converter {
    private Map<Long, String> moth;

    public ValidatorSqlru() {
        this.moth = new HashMap<>();
        this.initvalMoth();

    }


    /**
     * Метод проверяет название вакансии на соответствие
     *
     * @param title Название вакансии
     * @return true/false
     */
    @Override
    public boolean checkKeyWords(String title) {
        String s = title.toLowerCase();
        return s.contains("java") && !s.contains("script");
    }

    /**
     * Метод парсит дату и преобразовывает его в long представление , используется DateTimeFormatter с custom паттернами разбора строки.
     *
     * @param time строковое представление даты
     * @return long значение полученное
     */
    @Override
    public LocalDateTime convertTime(String time) {
        LocalDateTime rs = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();
        if (Objects.nonNull(time)) {
            if (time.contains("сегодня")) {
                String[] tmp = time.split(", ");
                LocalTime timeparse = LocalTime.parse(tmp[1], DateTimeFormatter.ofPattern("H:mm"));
                LocalDateTime rsval = localDate.atTime(timeparse);
                rs = rsval;


            } else if (time.contains("вчера")) {
                String[] tmp = time.split(", ");
                LocalTime timeparse = LocalTime.parse(tmp[1], DateTimeFormatter.ofPattern("H:mm"));
                LocalDateTime rsvalone = localDate.minusDays(1).atTime(timeparse);
                rs = rsvalone;

            } else {
                DateTimeFormatter dateTimeFormatter = new DateTimeFormatterBuilder().appendPattern("d ").appendText(ChronoField.MONTH_OF_YEAR, this.moth).appendPattern(" yy, H:mm").toFormatter();
                LocalDateTime parse = LocalDateTime.parse(time, dateTimeFormatter);
                rs = parse;
            }


        }


        return rs;

    }

    /**
     * Служебный метод заполнения hashMap значениями для парсинга даты .
     */
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
        this.moth.put(11L, "ноя");
        this.moth.put(12L, "дек");
    }

}
