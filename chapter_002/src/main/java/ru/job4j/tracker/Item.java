package ru.job4j.tracker;

import java.util.Arrays;

public class Item {
    public String id;
    public String name;
    public String desc;
    public long created;
    public String[] comments;

    /**
     * Конструктор для заявки
     *
     * @param name    имя.
     * @param desc    описание.
     * @param created время создания.
     */
    public Item(String name, String desc, long created) {
        this.name = name;
        this.desc = desc;
        this.created = created;
    }

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Item(String id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return "Item{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", desc='" + desc + '\'' + ", created=" + created + ", comments=" + Arrays.toString(comments) + '}';
    }

}