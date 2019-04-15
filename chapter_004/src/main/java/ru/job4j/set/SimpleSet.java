package ru.job4j.set;
import ru.job4j.generic.SimpleArray;
import java.util.Iterator;
import java.util.Objects;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 10.04.2019
 */
public class SimpleSet<E> implements Iterable<E> {
    private SimpleArray<E> simpleArray;


    public SimpleSet() {
        this.simpleArray = new SimpleArray<>(10);
    }

    /**
     * Метод добавляет в множество только уникальные значения
     *
     * @param value Элемент
     * @return boolean
     */
    public boolean add(E value) {
        boolean rs = false;
        if (this.isEmpty()) {
            simpleArray.add(value);
            rs = true;
        } else if (!this.findEquality(value)) {
            this.simpleArray.add(value);
            rs = true;

        }

        return rs;
    }

    /**
     * Проверка для метода add , есть ли идиентичный элемент в структуре
     *
     * @param value элемент
     * @return boolean
     */
    public boolean findEquality(E value) {
        boolean check = false;
        for (int i = 0; i < this.simpleArray.getPosition(); i++) {
            if (Objects.equals(this.simpleArray.get(i), value)) {
                check = true;
                break;
            }
        }
        return check;
    }

    /**
     * Метод проверяет что структура пуста.
     * @return boolean
     */
    public boolean isEmpty() {
        return this.simpleArray.getPosition() == 0;
    }

    @Override
    public Iterator<E> iterator() {

        return simpleArray.iterator();
    }
}
