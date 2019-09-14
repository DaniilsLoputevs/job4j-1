package ru.job4j.parsing;

import java.time.LocalDateTime;

public  abstract class DataType {

    abstract String getUrl();

    abstract void setUrl(String s);


    abstract String getTitle();


    abstract void setTitle(String title);

    abstract String getText();


    abstract void setText(String text);


    abstract LocalDateTime getTime();


    abstract void setTime(LocalDateTime time);

}
