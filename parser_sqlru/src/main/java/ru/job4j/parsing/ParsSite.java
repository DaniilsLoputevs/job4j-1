package ru.job4j.parsing;

import java.util.List;

public interface ParsSite {

    List<? extends DataType> parsing(String url);

}
