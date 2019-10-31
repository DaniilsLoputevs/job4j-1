package ru.job4j.concurrency;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Objects;

@ThreadSafe
public class User {
    private int id;
    private volatile int anmount;


    public User(int id, int anmount) {
        this.id = id;
        this.anmount = anmount;
    }

    public int getId() {
        return id;
    }

    public synchronized int getAnmount() {
        return anmount;
    }
    public synchronized void setAnmount(int anmount) {
        this.anmount = anmount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id
                &&
                anmount == user.anmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, anmount);
    }

    @Override
    public String toString() {
        return "User{"
                +
                "id="
                + id
                +
                ", anmount="
                + anmount
                +
                '}';
    }
}
