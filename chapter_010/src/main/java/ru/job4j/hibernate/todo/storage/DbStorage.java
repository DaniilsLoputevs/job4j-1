package ru.job4j.hibernate.todo.storage;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.job4j.hibernate.todo.model.Item;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Collection;

public class DbStorage implements Store {
    private static final DbStorage INSTANCE = new DbStorage();
    private final SessionFactory sessionFactory;

    private DbStorage() {
        this.sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    /**
     * add new row in database
     *
     * @param item entity value
     */
    @Override
    public void add(Item item) {
        Session s = getConnection();
        s.beginTransaction();
        s.save(item);
        s.getTransaction().commit();


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
     * @see "https://stackoverflow.com/questions/43037814/how-to-get-all-data-in-the-table-with-hibernate"
     */
    @SuppressWarnings("unchecked")
    @Override
    public Collection<Item> findAll() {
        Session session = getConnection();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(Item.class);
        criteriaQuery.from(Item.class);
        return session.createQuery(criteriaQuery).getResultList();
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
    private Session getConnection() {
        return sessionFactory.openSession();
    }

    public static DbStorage getInstance() {
        return INSTANCE;
    }

//    public static void main(String[] args) {
//        DbStorage dbStorage = new DbStorage();
//        dbStorage.add(new Item("Repare", "TASDASDasdssad", Timestamp.valueOf(LocalDateTime.now())));
//        dbStorage.replace(new Item(1, "Repareddddd", "TASDASDasdssad", Timestamp.valueOf(LocalDateTime.now()), false));
//        System.out.println(dbStorage.findAll());
//        System.out.println(dbStorage.findById(new Item(1)));
////        dbStorage.delete(new Item(1, "Repareddddd", "TASDASDasdssad", Timestamp.valueOf(LocalDateTime.now()),false));
//    }
}
