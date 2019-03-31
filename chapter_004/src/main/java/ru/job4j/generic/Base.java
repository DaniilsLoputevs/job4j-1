package ru.job4j.generic;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 01$
 * @since 29.03.2019
 */
public abstract class Base {
    private final String id;

    protected Base(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Base{"
                +
                "id='"
                + id
                + '\''
                +
                '}';
    }
}
