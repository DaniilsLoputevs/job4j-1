package ru.job4j.io;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 21.06.2019
 */
public class Args {

    private String dir;
    private String ex;
    private String out;

    public Args(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-d")) {
                this.dir = args[i + 1];
            }
            if (args[i].equals("-e")) {
                this.ex = args[i + 1];

            }
            if (args[i].equals("-o")) {
                this.out = args[i + 1];
            }
        }
    }


    public String directory() {
        return this.dir;
    }

    public String ex() {
        return this.ex;
    }

    public String output() {
        return this.out;
    }


    }

