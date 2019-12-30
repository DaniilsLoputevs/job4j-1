package ru.job4j.servletapi.crud.servlets;

import ru.job4j.servletapi.crud.Validate;
import ru.job4j.servletapi.crud.models.User;

import java.util.*;

public class ValidateStub implements Validate {
    private final Map<String, User> map = new HashMap<>();
    private int id = 0;

    public ValidateStub() {
    }

    /**
     * Add new user in storage and inc id count
     * no checking user by including data
     *
     * @param user adding value
     * @return boolean result
     */
    @Override
    public boolean add(User user) {
        String ids = String.valueOf(this.id++);
        user.setId(ids);
        Optional<User> adding = Optional.ofNullable(this.map.put(user.getId(), user));
        return adding.isPresent();
    }

    /**
     * Method update storage
     *
     * @param user new value
     * @return boolean result
     */
    @Override
    public boolean update(User user) {
        Optional<User> updated = Optional.ofNullable(this.map.replace(user.getId(), user));
        return updated.isPresent();
    }

    /**
     * Delete user in storage
     *
     * @param user deleted value
     * @return boolean result
     */
    @Override
    public boolean delete(User user) {
        Optional<User> removed = Optional.ofNullable(map.remove(user.getId()));
        return removed.isPresent();
    }

    /**
     * Find value in storage by id
     *
     * @param user Value
     * @return boolean result
     */
    @Override
    public boolean findById(User user) {
        Optional<User> rs = Optional.ofNullable(map.get(user.getId()));
        return rs.isPresent();
    }

    /**
     * Return all values in storage
     *
     * @return ArrayList of User
     */
    @Override
    public Collection<User> findAll() {
        return new ArrayList<User>(this.map.values());
    }
}
