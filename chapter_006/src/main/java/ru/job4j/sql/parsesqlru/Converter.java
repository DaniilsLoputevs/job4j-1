package ru.job4j.sql.parsesqlru;

import java.time.LocalDateTime;

public interface Converter {

    LocalDateTime convertTime(String value);
}
