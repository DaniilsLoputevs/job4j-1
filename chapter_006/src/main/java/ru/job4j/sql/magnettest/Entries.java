package ru.job4j.sql.magnettest;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Entries {
    @XmlElement
    private List<Entry> entry;

    public Entries() {

    }

    public void setEntryList(List<Entry> entryList) {
        this.entry = entryList;
    }

}
