package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Objects;

public class Item {
    /**
     * Поля которые описывают заявки.
     */
    private String id;
    private String name;
    private String desc;
    private long created;
    private String[] comments;


    public Item(String id, String name, String desc, long time) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.created = time;
    }

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

    /**
     * Конструктор для заявки.
     *
     * @param name
     * @param desc
     */
    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    /**
     * Конструктор для заявки.
     *
     * @param id
     * @param name
     * @param desc
     */

    public Item(String id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    /**
     * Сеттер для id
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Геттер для id
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Геттер для name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    public String[] getComments() {
        return comments;
    }

    public String getDesc() {
        return desc;
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

    public void setCreated(long created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Item{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", desc='" + desc + '\'' + ", created=" + created + ", comments=" + Arrays.toString(comments) + '}';
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
        return created == item.created
                &&
                Objects.equals(id, item.id)
                &&
                Objects.equals(name, item.name)
                &&
                Objects.equals(desc, item.desc)
                &&
                Arrays.equals(comments, item.comments);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name, desc, created);
        result = 31 * result + Arrays.hashCode(comments);
        return result;
    }
}