package ru.job4j.io.finder;

import ru.job4j.io.Args;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 21.07.2019
 */
public class FinderArgs extends Args {
    private String name;
    private String mode;

    public FinderArgs(String[] args) {
        super(args);
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-n")) {
                this.name = args[i + 1];
            }
            if (args[i].equals("-m")) {
                this.mode = args[i + 1];
            }
        }
    }

    public String getSearchName() {
        return name;
    }

    public String getWorkMode() {
        return mode;
    }
}
