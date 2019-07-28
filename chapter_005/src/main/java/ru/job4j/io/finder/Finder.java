package ru.job4j.io.finder;

import ru.job4j.io.Search;

import java.io.*;
import java.util.List;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 19.07.2019
 */
public class Finder {
    private Search search;
    private FinderArgs arg;

    public Finder(String[] args) {
        this.search = new Search();
        this.arg = new FinderArgs(args);
    }

    public void startFinder() {
        List<File> rs = search.filesByName(this.arg.directory(), this.arg.getSearchName());
        try (PrintWriter out = new PrintWriter(new FileOutputStream(this.arg.output(), false))) {
            for (File f : rs) {
                String s = f.getName();
                out.write(s + System.lineSeparator());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        Finder finder = new Finder(args);
        finder.startFinder();

    }
}
