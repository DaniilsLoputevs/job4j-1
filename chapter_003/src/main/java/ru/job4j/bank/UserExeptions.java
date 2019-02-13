package ru.job4j.bank;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 11.02.2019
 */
public class UserExeptions extends RuntimeException {

    public UserExeptions(String message) {
        super(message);
    }
}
