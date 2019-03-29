package ru.job4j.generic;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 01$
 * @since 29.03.2019
 */
public interface Store<T extends Base> {
    /**
     * Добавление модели в структуру.
     *
     * @param model обьект T некоторого класса наследующего Base.
     */
    void add(T model);

    /**
     * Изменение в структуре обьекта T используя строковый id
     *
     * @param id    идентификатор
     * @param model обьект.
     */
    boolean replace(String id, T model);

    /**
     * Удаление обьекта по id
     *
     * @param id идентификатор
     * @return ожидаемое булево значение.
     */
    boolean delete(String id);

    /**
     * Поиск обьекта по идентификатору.
     *
     * @param id идентификатор.
     * @return найденный обьект.
     */
    T findById(String id);
}
