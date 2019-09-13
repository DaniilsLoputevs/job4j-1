package ru.job4j.parsing;

import java.time.LocalDateTime;

public interface Converter {

    LocalDateTime convertTime(String value);
}
