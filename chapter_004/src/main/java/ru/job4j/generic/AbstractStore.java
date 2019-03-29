package ru.job4j.generic;


import java.util.Objects;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 31.03.2019
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {
    private SimpleArray<T> simpleArray = new SimpleArray<>(10);

    /**
     * Метод добавления элемента в структуру.
     *
     * @param model обьект T некоторого класса наследующего Base.
     */
    @Override
    public void add(T model) {
        simpleArray.add(model);
    }

    /**
     * Замена эдементом в структуре с использованием идентификатора.
     *
     * @param id    идентификатор
     * @param model обьект.
     * @return
     */
    @Override
    public boolean replace(String id, T model) {
        boolean rs = false;
        for (int i = 0; i < simpleArray.size(); i++) {
            if (!Objects.isNull(simpleArray.get(i)) && simpleArray.get(i).getId().equals(id)) {
                simpleArray.set(i, model);
                rs = true;
                break;
            }
        }
        return rs;
    }

    /**
     * Удаление элемента из структуры с использованием идентификатора.
     *
     * @param id идентификатор
     * @return
     */
    @Override
    public boolean delete(String id) {
        boolean rs = false;
        for (int i = 0; i < simpleArray.size(); i++) {
            if (!Objects.isNull(simpleArray.get(i)) && simpleArray.get(i).getId().equals(id)) {
                simpleArray.remove(i);
                rs = true;
            }
        }
        return rs;
    }

    /**
     * Поиск элемента с использованием идентификатора.
     *
     * @param id идентификатор.
     * @return
     */
    @Override
    public T findById(String id) {
        T value = null;
        for (int i = 0; i < simpleArray.size(); i++) {
            if (!Objects.isNull(simpleArray.get(i)) && simpleArray.get(i).getId().equals(id)) {
                value = simpleArray.get(i);
                break;
            }
        }
        return value;
    }


    @Override
    public String toString() {
        return "AbstractStore{"
                +
                "simpleArray="
                + simpleArray
                +
                '}';
    }
}
