package ru.job4j.hibernate.todo.model;

import java.sql.Timestamp;
import java.util.Objects;

public class Item {
    private Integer id;
    private String name;
    private String desc;
    private Timestamp created;
    private boolean done;


    public Item(Integer id) {
        this.id = id;
    }

    public Item() {

    }

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }


    public Item(String name, String desc, Timestamp created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }

    public Item(Integer id, String name, String desc, Timestamp created, boolean done) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.created = created;
        this.done = done;
    }

    public Item(String name, String desc, Timestamp created, boolean done) {
        this.name = name;
        this.desc = desc;
        this.created = created;
        this.done = done;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }


    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return done == item.done
                &&
                Objects.equals(id, item.id)
                &&
                Objects.equals(name, item.name)
                &&
                Objects.equals(desc, item.desc)
                &&
                Objects.equals(created, item.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, desc, created, done);
    }

    @Override
    public String toString() {
        return "Item{"
                +
                "id="
                + id
                +
                ", name='"
                + name
                + '\''
                +
                ", desc='"
                + desc
                + '\''
                +
                ", created="
                + created
                +
                ", done="
                + done
                +
                '}';
    }
}
