package ru.job4j.sql.parsesqlru;

import java.sql.Timestamp;

public class Vacancy {

    private String url;
    private String name;
    private String text;
    private Timestamp timestamp;

    public Vacancy(String url, String name, String text, Timestamp timestamp) {
        this.url = url;
        this.name = name;
        this.text = text;
        this.timestamp = timestamp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
