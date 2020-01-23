package ru.job4j.storeauto.hiberutils;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.function.Function;

public class FuncSessionOpen {

    public static   <T> T funcApplyCommand(final Function<Session, T> command) {
        final Session session = HiberFactory.getSessionFactory().openSession();
        final Transaction transaction = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            transaction.commit();
            return rsl;
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
