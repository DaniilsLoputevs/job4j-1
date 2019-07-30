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
    private String name;
    private String mode;

    public Args() {
    }

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

    public Args(String rootpath, String name, String output) {
        this.dir = rootpath;
        this.name = name;
        this.out = output;
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

    public String getName() {
        return name;
    }

    public String getMode() {
        return mode;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public void setEx(String ex) {
        this.ex = ex;
    }

    public void setOut(String out) {
        this.out = out;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }


}

