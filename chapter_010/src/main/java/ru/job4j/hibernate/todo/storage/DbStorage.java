package ru.job4j.hibernate.todo.storage;


import org.hibernate.Session;
import org.hibernate.Transaction;

import ru.job4j.hibernate.todo.model.Item;
import ru.job4j.hibernate.todo.util.HiberUtil;

import java.util.Collection;
import java.util.function.Function;

public class DbStorage implements Store {
    private static final DbStorage INSTANCE = new DbStorage();

    private DbStorage() {
    }

    /**
     * add new row in database
     *
     * @param item entity value
     */
    @Override
    public Item add(Item item) {
        tx(session -> session.save(item));
        return item;
    }

    /**
     * Replace item . using id
     *
     * @param item new entity
     */
    @Override
    public void replace(Item item) {
        Session s = getConnection();
        s.getTransaction();
        s.update(item);
        s.beginTransaction().commit();

    }

    /**
     * @return all data in database
     * 3
     */
    @SuppressWarnings("unchecked")
    @Override
    public Collection<Item> findAll() {
        return tx(session -> HiberUtil.getSessionFactory().openSession().createQuery("from Item ")).list();
    }

    /**
     * delete entity by id
     *
     * @param item deleted entity
     */
    @Override
    public void delete(Item item) {
        Session session = getConnection();
        session.getTransaction();
        session.delete(item);
        session.beginTransaction().commit();

    }

    @Override
    public Item findById(Item item) {
        Session session = getConnection();
        session.getTransaction();
        session.load(Item.class, item.getId());
        return session.load(Item.class, item.getId());
    }

    /**
     * servlets func return new session
     *
     * @return session
     */
    private  Session getConnection() {
        return HiberUtil.getSessionFactory().openSession();
    }

    public static DbStorage getInstance() {
        return INSTANCE;
    }

    private <T> T tx(final Function<Session, T> command) {
        final Session session = HiberUtil.getSessionFactory().openSession();
        final Transaction tx = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            tx.commit();
            return rsl;
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

}
