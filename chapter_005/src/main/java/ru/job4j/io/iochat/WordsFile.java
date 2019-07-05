package ru.job4j.io.iochat;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 01$
 * @since 27.06.2019
 */
public class WordsFile {
    private final String path;
    private List<String> words;

    /**
     * Конструктор выполняет инициализацию полей и выполняет метод init()
     */
    public WordsFile() {
        this.path = System.getProperty("java.io.tmpdir") + "wordlist.txt";
        words = new ArrayList<>();
        this.init();
    }

    public WordsFile(String words) {
        this.words = List.of(words);
        this.path = System.getProperty("java.io.tmpdir") + "wordlist.txt";
    }


    /**
     * Метод заполняет файл фразами/словами в файл и добавляет их в список words
     */
    private void init() {
        List<String> word = List.of("Hello", "Write Anything", "What?", "Nice try", "Wrong answer", "How are you?", "Why you write again");
        try (DataOutputStream br = new DataOutputStream(new FileOutputStream(this.path))) {
            for (String out : word) {
                br.writeUTF(out + System.lineSeparator());
                this.words.add(out);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод возвращает из списка слов случайное
     *
     * @return Случайная фраза из списка.
     */
    public String getRandomWords() {
        Random random = new Random();
        int index = 0 + random.nextInt(this.words.size() - 0);
        return this.words.get(index);
    }


}
