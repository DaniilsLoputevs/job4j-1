package ru.job4j.storeauto.hiberutils;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.storeauto.dao.AccountsDao;

import java.util.function.Function;

public class FuncSessionOpen {
    private final static Logger LOGGER = LoggerFactory.getLogger(FuncSessionOpen.class);

    public static <T> T funcApplyCommand(final Function<Session, T> command) {
        final Session session = HiberFactory.getSessionFactory().openSession();
        final Transaction transaction = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            transaction.commit();
            return rsl;
        } catch (final Exception e) {
            LOGGER.error(e.getMessage(), e);
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
