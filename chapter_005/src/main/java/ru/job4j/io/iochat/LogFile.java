package ru.job4j.io.iochat;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 28.06.2019
 */
public class LogFile {
    private final String path;
    private List<String> log;

    /**
     * Конструктор инициализирует поля и выполняет метод init()
     */
    public LogFile() {
        log = new ArrayList<>();
        this.path = System.getProperty("java.io.tmpdir") + File.separator + "/logchat.txt";
        this.init();
    }

    /**
     * Метод инициализирует файл лога чата .
     */
    private void init() {
        try {
            File create = new File(this.path);
            create.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод возвращает путь к файлу
     *
     * @return String путь к лог файлу .
     */

    public String getFilePath() {
        return this.path;
    }

    public List<String> getLog() {
        return log;
    }
}
