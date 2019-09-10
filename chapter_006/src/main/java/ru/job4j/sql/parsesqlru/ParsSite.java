package ru.job4j.sql.parsesqlru;

import java.util.List;

public interface ParsSite {

    List<? extends DataType> parsing(String url);
}
