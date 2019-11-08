package ru.job4j.concurrency.problems;

import java.util.Objects;

public class Base {
    private int id;
    private int version;
    private int data;

    public Base(int id, int data) {
        this.id = id;
        this.data = data;
        this.version = 0;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Base base = (Base) o;
        return id == base.id
                &&
                version == base.version
                &&
                data == base.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, data);
    }

    @Override
    public String toString() {
        return "Base{"
                +
                "id="
                + id
                +
                ", version="
                + version
                +
                ", data="
                + data
                +
                '}';
    }
}
