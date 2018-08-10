package ru.job4j.tracker;

import java.util.List;
import java.util.Scanner;
/**
 * Package for OOP task.
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 08.08.2018
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    @Override
    public int ask(String question, List<Integer> range) {
        int res = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == res) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            throw new MenuOutofExeption("Введите правильный пункт меню.");


        }
        return res;


    }
}
