package ru.job4j.concurrency;

import net.jcip.annotations.ThreadSafe;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@ThreadSafe
public class UserStorage {
    private volatile Map<Integer, User> chm;

    public UserStorage() {
        this.chm = new ConcurrentHashMap<>();
    }

    public void add(User user) {
        chm.put(user.getId(), user);
    }

    public boolean update(int id, User user) {
        return Objects.nonNull(chm.replace(id, user));
    }

    public boolean delete(User user) {
        return Objects.nonNull(chm.remove(user.getId()));
    }


    public Map<Integer, User> getChm() {
        return chm;
    }

    public boolean transfer(int sourceid, int desctinationid, int amount) {
        boolean cantransfer = false;
        Optional<User> src = Optional.ofNullable(chm.get(sourceid));
        Optional<User> dst = Optional.ofNullable(chm.get(desctinationid));
        if (src.isPresent() && dst.isPresent()) {
            cantransfer = src.get().getAnmount() >= amount;
        }
        if (cantransfer) {
            src.ifPresent(user -> user.setAnmount(user.getAnmount() - amount));
            dst.ifPresent(user -> user.setAnmount(user.getAnmount() + amount));
        }
        return cantransfer;
    }

}
