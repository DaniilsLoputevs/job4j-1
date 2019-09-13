package ru.job4j.parsing;

import java.time.LocalDateTime;
import java.util.Objects;

public class Vacancy extends DataType {

    private String url;
    private String title;
    private String text;
    private LocalDateTime localDateTime;

    public Vacancy(String url, String title, String text, LocalDateTime localDateTime) {
        this.url = url;
        this.title = title;
        this.text = text;
        this.localDateTime = localDateTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getTime() {
        return localDateTime;
    }

    public void setTime(LocalDateTime time) {
        this.localDateTime = localDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vacancy vacancy = (Vacancy) o;
        return Objects.equals(url, vacancy.url)
                &&
                Objects.equals(title, vacancy.title)
                &&
                Objects.equals(text, vacancy.text)
                &&
                Objects.equals(localDateTime, vacancy.localDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, title, text, localDateTime);
    }

    @Override
    public String toString() {
        return "Vacancy{"
                +
                "url='"
                + url
                + '\''
                +
                ", title='"
                + title
                + '\''
                +
                ", text='"
                + text
                + '\''
                +
                ", localDateTime="
                + localDateTime
                +
                '}';
    }
}
