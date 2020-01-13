package ru.job4j.hibernate.todo.model;

import java.sql.Timestamp;
import java.util.Objects;

public class Item {
    private Integer id;
    private String name;
    private String desc;
    private Timestamp created;

    public Item(){

    };

    public Item(String name, String desc, Timestamp created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }
    public Item(Integer id,String name, String desc, Timestamp created) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.created = created;
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



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return
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
        return Objects.hash(id, name, desc, created);
    }

    @Override
    public String toString() {
        return "Item{"
                +
                "id='"
                + id
                + '\''
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
                '}';
    }
}
