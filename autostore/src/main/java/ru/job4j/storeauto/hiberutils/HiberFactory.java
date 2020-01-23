package ru.job4j.storeauto.hiberutils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HiberFactory {
    private static final SessionFactory SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}
