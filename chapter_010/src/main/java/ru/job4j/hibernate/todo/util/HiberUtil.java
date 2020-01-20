package ru.job4j.hibernate.todo.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HiberUtil {
    private static final SessionFactory SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

    /**
     * static func return Session Factory
     * @return
     */
    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}
