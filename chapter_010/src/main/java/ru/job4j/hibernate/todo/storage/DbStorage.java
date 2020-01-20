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
        funcApplyCommand(session -> session.save(item));
        return item;
    }

    /**
     * Replace item . using id
     *
     * @param item new entity
     */
    @Override
    public void replace(Item item) {
        funcApplyCommand(session -> {
            session.update(item);
            return item;
        });
    }

    /**
     * @return all data in database
     * 3
     */
    @SuppressWarnings("unchecked")
    @Override
    public Collection<Item> findAll() {
        return funcApplyCommand(session -> session.createQuery("from Item order by created").list());
    }

    /**
     * delete entity by id
     *
     * @param item deleted entity
     */
    @Override
    public void delete(Item item) {
        funcApplyCommand(session -> {
            session.delete(item);
            return item;
        });
    }

    @Override
    public Item findById(Item item) {

        return funcApplyCommand(session -> {
            Item rs = null;
            rs = session.get(Item.class, item.getId());
            return rs;
        });
    }

    public static DbStorage getInstance() {
        return INSTANCE;
    }

    private <T> T funcApplyCommand(final Function<Session, T> command) {
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

    public static void main(String[] args) {
        DbStorage storage = new DbStorage();
        System.out.println(storage.findById(new Item(1)));
    }


}
