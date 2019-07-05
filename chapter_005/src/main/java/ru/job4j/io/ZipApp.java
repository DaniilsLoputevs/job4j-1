package ru.job4j.io;

import java.io.File;
import java.util.List;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 22.06.2019
 */
public class ZipApp {


    public static void main(String[] args) {
        Args args1 = new Args(args);
        Zip zip = new Zip(args);
        List<File> seekBy = zip.seekBy(args1.directory(), args1.ex());
        zip.pack(seekBy, new File(args1.output()));


    }
}
