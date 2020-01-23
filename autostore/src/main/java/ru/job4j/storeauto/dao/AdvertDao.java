package ru.job4j.storeauto.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.job4j.storeauto.hiberutils.HiberFactory;
import ru.job4j.storeauto.models.Advert;
import ru.job4j.storeauto.store.Store;

import java.util.List;
import java.util.function.Function;

public class AdvertDao implements Store<Advert> {
    @Override
    public void add(Advert value) {
        func(session -> session.save(value));
    }

    @Override
    public void replace(Advert value) {
        func(session -> {
            session.update(value);
            return value;
        });

    }

    @Override
    public void delete(Advert value) {
        func(session -> {
            session.delete(value);
            return value;
        });

    }

    @Override
    public List<Advert> findAll() {
        return null;
    }

    /**
     * Lambda func for all dao function
     * Open session , open Transaction
     *
     * @param command command
     * @param <T>     Generic
     * @return
     */
    private <T> T func(final Function<Session, T> command) {
        final Session session = HiberFactory.getSessionFactory().getCurrentSession();
        final Transaction transaction = session.beginTransaction();
        try {
            T rs = command.apply(session);
            transaction.commit();
            return rs;
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }

    }
}
