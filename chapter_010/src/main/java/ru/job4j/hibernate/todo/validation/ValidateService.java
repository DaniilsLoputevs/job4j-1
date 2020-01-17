package ru.job4j.hibernate.todo.validation;

import ru.job4j.hibernate.todo.model.Item;
import ru.job4j.hibernate.todo.storage.DbStorage;
import ru.job4j.hibernate.todo.storage.Store;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

public class ValidateService implements Validate {
    private final Store storage = DbStorage.getInstance();
    private static final ValidateService VALIDATE_SERVICE = new ValidateService();

    private ValidateService() {
    }

    /**
     * func add entity but before check item object and set current time
     * <p>
     * see -> checkModel()
     *
     * @param item adding entity
     * @return true if all check success
     */
    @Override
    public boolean add(Item item) {
        boolean rs = checkModel(item);
        if (rs) {
            item.setCreated(Timestamp.valueOf(LocalDateTime.now()));
            storage.add(item);
        }
        return checkModel(item);
    }

    /**
     * func replace old data in db , if find on db
     *
     * @param item new data
     * @return true if model find in db
     */
    @Override
    public boolean replace(Item item) {
        Optional<Item> finded = Optional.ofNullable(storage.findById(item));
        if (finded.isPresent()) {
            storage.replace(item);
        }
        return finded.isPresent();
    }

    /**
     * func delete data in db , if this data contains
     *
     * @param item deleted value
     * @return true if find on db
     */
    @Override
    public boolean delete(Item item) {
        Optional<Item> delete = Optional.ofNullable(storage.findById(item));
        if (delete.isPresent()) {
            storage.delete(item);
        }
        return delete.isPresent();
    }

    /**
     * func return all data in db
     *
     * @return List data
     */
    @Override
    public Collection<Item> findAll() {
        return storage.findAll();
    }

    /**
     * util func check model
     *
     * @param item check entity
     * @return true if all condition return true
     */
    private boolean checkModel(Item item) {
        boolean rs = false;
        if (Objects.nonNull(item.getName()) && Objects.nonNull(item.getDesc())) {
            rs = true;
        }
        return rs;
    }

    public static ValidateService getValidateService() {
        return VALIDATE_SERVICE;
    }

    public static void main(String[] args) {
        ValidateService validateService = new ValidateService();
        validateService.add(new Item("name", "desc", Timestamp.valueOf(LocalDateTime.now())));
    }


}
