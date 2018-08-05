package ru.job4j.tracker;

import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    public int ask(String message, int[] range) {
        int key = Integer.valueOf(this.ask(message));
        boolean exist = false;
        for (int i = 0; i < range.length; i++) {
            if (range[i] == key) {
                exist = true;
                break;
            }
        }

    }

}
