package ru.job4j.tracker;

/**
 * Package for OOP task.
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $Id$
 * @since 05.07.2018
 **/

public interface UserAction {

    int key();


    void execute(Input input, Tracker tracker);

    String info();
}