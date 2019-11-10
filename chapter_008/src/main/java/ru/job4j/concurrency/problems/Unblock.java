package ru.job4j.concurrency.problems;


import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class Unblock {
    private final ConcurrentHashMap<Integer, Base> map;

    public Unblock() {
        this.map = new ConcurrentHashMap<>();
    }

    /**
     * Добавление модели в кеш.
     * @param value модель
     */
    public void add(Base value) {
        map.put(value.getId(), value);
    }

    /**
     * Обновление модели в мапе , если версии не совпадает при изменении , пробрасывается исключение.
     * @param value модель
     * @return true/false
     */
    public boolean update(Base value) {
        boolean rs = false;
        Optional<Base> a = Optional.ofNullable(map.get(value.getId()));
        if (a.isPresent()) {
            if (a.get().getVersion() == value.getVersion()) {
                int v = a.get().getVersion();
                value.setVersion(++v);
                map.computeIfPresent(value.getId(), ((integer, base) -> base = value));
                rs = true;
            } else {
                throw new OptimisticException();
            }
        }

        return rs;
    }

    /**
     * Удаление модели из кеша
     * @param value модель
     */
    public void delete(Base value) {
        map.remove(value.getId());
    }

    public ConcurrentHashMap<Integer, Base> getMap() {
        return map;
    }

    public static void main(String[] args) {
        Unblock unblock = new Unblock();
        Base base = new Base(1, 44);
        Base base1 = new Base(1, 47);
        base1.setVersion(1);
        unblock.add(base);
        System.out.println(unblock.map);
        unblock.update(new Base(1, 45));
        unblock.update(base1);
        System.out.println(unblock.map);

    }
}
