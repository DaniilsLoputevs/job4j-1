package ru.job4j.io.iochat;


import java.io.*;


/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 01$
 * @since 27.06.2019
 */
public class ConsoleChat {
    private WordsFile wordsFile;
    private LogFile logFile;
    private boolean work;
    private boolean pause;
    private final BufferedReader inputData;
    private final PrintStream outData;

    /**
     * Конструктор инициализирует обьекты и внутренние поля .
     */
    public ConsoleChat() {
        this.work = true;
        this.wordsFile = new WordsFile();
        this.pause = false;
        this.logFile = new LogFile();
        this.inputData = new BufferedReader(new InputStreamReader(System.in));
        this.outData = new PrintStream(System.out);

    }

    /**
     * Конструктор с возможностью замены потоков ввода и вывода.
     *
     * @param inputData - поток ввода
     * @param outData   - поток вывода
     */
    public ConsoleChat(BufferedReader inputData, PrintStream outData, WordsFile wordsFile) {
        this.inputData = inputData;
        this.outData = outData;
        this.work = true;
        this.wordsFile = wordsFile;
        this.pause = false;
        this.logFile = new LogFile();

    }

    /**
     * Доступ к потоку ввода.
     *
     * @return
     */
    public BufferedReader getInputData() {
        return inputData;
    }

    /**
     * Доступ к потоку вывода
     *
     * @return
     */
    public PrintStream getOutData() {
        return outData;
    }


    public LogFile getLogFile() {
        return logFile;
    }

    /**
     * Метод осуществляет консольный ввод текста пользователя и случайных фраз из обьекта WordsFile , добавляет лог в обьект Logfile.
     */

    private void input() {
        String in;
        String out;
        try (BufferedReader bufferedReader = this.getInputData();
             PrintStream printStream = this.getOutData()) {
            while (this.work) {
                in = bufferedReader.readLine();
                this.exit(in);
                this.isPause(in);
                if (!this.pause) {
                    out = this.wordsFile.getRandomWords();
                    printStream.println(out);
                    this.logFile.getLog().add(out);
                }
                this.logFile.getLog().add(in);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод осуществляет запись лога в файл
     */
    private void output() {
        try (PrintWriter log = new PrintWriter(new FileOutputStream(this.logFile.getFilePath()))) {
            for (String s : this.logFile.getLog()) {
                log.write(s + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Метод запускает методы ввода и записи лога
     */

    public void start() {
        this.input();
        this.output();

    }

    /**
     * Метод проверки введенного слова пользователем о завершении работы
     *
     * @param inputWord - введенное слово пользователем.
     * @return true/false
     */

    private boolean exit(String inputWord) {
        boolean rs = false;
        if (inputWord.equals("закончить")) {
            this.work = false;
            this.pause = true;
            rs = true;
        }
        return rs;
    }

    /**
     * Метод проверки введенного слова пользователем о приостановке вывода случайных фраз.
     *
     * @param inputWord введенное слово пользователем  , если стоп (приостановить вывод случайных фраз) если продолжить(продолжить вывод случайных фраз)
     * @return true/false
     */
    private boolean isPause(String inputWord) {
        boolean rs = false;
        if (inputWord.equals("стоп")) {
            this.pause = true;
            rs = true;
        } else if (inputWord.equals("продолжить")) {
            rs = false;
            this.pause = false;
        }
        return rs;
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat();
        consoleChat.start();


    }
}
