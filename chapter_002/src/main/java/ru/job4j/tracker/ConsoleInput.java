package ru.job4j.tracker;

import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }


    public int ask(String question, List<Integer> range) {
        int res = Integer.valueOf(this.ask(question));
        return res;
    }



}
