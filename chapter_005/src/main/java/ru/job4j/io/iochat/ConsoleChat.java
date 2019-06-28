package ru.job4j.io.iochat;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 01$
 * @since 27.06.2019
 */
public class ConsoleChat {
    private WordsFile wordsFile;
    private List<String> log;
    private boolean work;
    private boolean pause;

    public ConsoleChat() {
        this.log = new ArrayList<>();
        this.work = true;
        this.wordsFile = new WordsFile(System.getProperty("java.io.tmpdir") + "wordlist.txt");
        this.pause = false;


    }


    public void input() {
        String in;
        String randomin;
        try (BufferedReader inputByUser = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader inputByRandomWords = new BufferedReader(new FileReader(this.wordsFile.getFile()))) {
            in = inputByUser.readLine();

//            if (!this.isPause(in)) {
//                System.out.println(randomin = inputByRandomWords.readLine());
//                this.log.add(randomin);
//            }
//            this.log.add(in);
//            if (work) {
//                this.input();
//            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean stop(String inputWord) {
        boolean rs = false;
        if (inputWord.equals("закончить")) {
            System.out.println("Работа программы завершена");
            this.work = false;
            rs = true;
        }
        return rs;
    }

    private boolean isPause(String inputWord) {
        boolean rs = false;
        if (inputWord.equals("стоп")) {
            this.pause = true;
            rs = true;
        }
        return rs;
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat();
        consoleChat.input();
    }
}
