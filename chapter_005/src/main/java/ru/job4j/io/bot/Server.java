package ru.job4j.io.bot;

import ru.job4j.io.iochat.WordsFile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 01$
 * @since 12.07.2019
 */
public class Server {
    private boolean work;
    private int port;
    private WordsFile wordsFile;
    private ServerSocket serverSocket;
    private Socket socket;

    /**
     * Конструктор с передачей сокета
     *
     * @param socket
     * @throws IOException
     */
    public Server(Socket socket, WordsFile wordsFile) throws IOException {
        this.work = true;
        this.wordsFile = wordsFile;
        this.socket = socket;
    }

    /**
     * Конструктор инциализирует обьект
     *
     * @throws IOException
     */
    public Server() throws IOException {
        this.port = 5000;
        this.work = true;
        this.wordsFile = new WordsFile();
        this.serverSocket = new ServerSocket(this.port);
        this.socket = new Socket();
        System.out.println("Ждём подключения к серверу");
        this.socket = serverSocket.accept();
        System.out.println("Подключение состоялось");

    }

    /**
     * Метод с основной логикой работы сервера , принимает данные от клиента и отправляет случайную фразу из обьекта WordsFile
     */
    public void outputData() {
        try (BufferedReader input = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
             PrintWriter output = new PrintWriter(socket.getOutputStream(), true)) {
            String in = null;
            while (this.work) {
                in = input.readLine();
                while (!in.isEmpty()) {
                    System.out.println("Сообщение от клиента " + in);
                    if (this.close(in)) {
                        break;
                    }
                    in = input.readLine();
                }
                output.println(this.wordsFile.getRandomWords());
                output.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод проверяет входящее слово и завершает подключение
     *
     * @param word входяшее слово
     * @return
     */
    private boolean close(String word) {
        boolean rs = false;
        if (word.equalsIgnoreCase("закончить")) {
            rs = true;
            this.work = false;
        }
        return rs;
    }


    public static void main(String[] args) throws IOException {
        try (Socket socket = new ServerSocket(5000).accept()) {
            WordsFile wordsFile = new WordsFile();
            new Server(socket, wordsFile).outputData();
        }
    }


}
