package ru.job4j.gc;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize");
    }

    @Override
    public String toString() {
        return "User{"
                +
                "name='"
                + name
                + '\''
                +
                '}';
    }

    public static void main(String[] args) {
        System.out.println("start");
        for (int i = 0; i < 200; i++) {
            new User("test");
            System.out.println("iteration " + i);
        }
        System.gc();

    }
}
