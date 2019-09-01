package ru.job4j.sql.magnettest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class Entry {
    @XmlElement
    private int field;

    public Entry() {
    }

    public Entry(int field) {
        this.field = field;
    }


    @Override
    public String toString() {
        return "Entry{"
                +
                "field="
                + field
                +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Entry entry = (Entry) o;
        return field == entry.field;
    }

    @Override
    public int hashCode() {
        return Objects.hash(field);
    }
}
