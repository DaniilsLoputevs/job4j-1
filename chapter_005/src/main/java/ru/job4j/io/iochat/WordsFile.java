package ru.job4j.io.iochat;

import java.io.File;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 01$
 * @since 27.06.2019
 */
public class WordsFile {
    private File file;

    public WordsFile(String path) {
        file = new File(path);
    }

    public File getFile() {
        return file;
    }

}
