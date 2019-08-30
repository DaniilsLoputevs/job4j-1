package ru.job4j.sql.magnettest;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

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


}
