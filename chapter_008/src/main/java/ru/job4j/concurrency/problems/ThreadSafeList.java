package ru.job4j.concurrency.problems;


import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;
import ru.job4j.list.DynamicList;

import java.util.Iterator;

@ThreadSafe
public class ThreadSafeList<E> implements Iterable {
    @GuardedBy("this")
    private DynamicList<E> dynamicList;

    public ThreadSafeList(DynamicList<E> dynamicList) {
        this.dynamicList = dynamicList;
    }

    /**
     * Добавление элемента в динамический список
     *
     * @param value
     */
    public synchronized void add(E value) {
        dynamicList.add(value);
    }

    /**
     * Получение элемента по индеку
     *
     * @param index искомый индекс
     * @return найденный элемент
     */
    public synchronized E get(int index) {
        return dynamicList.get(index);
    }

    /**
     * Получение размера списка
     *
     * @return возрат int значения размера коллекции
     */
    public synchronized int getSize() {
        return dynamicList.getSize();
    }

    /**
     * Утилитный метод копирования данных для последющем использовании в итераторе
     *
     * @param list внутренний список
     * @return слепок данных на еденицу времени.
     */
    private DynamicList<E> copy(DynamicList<E> list) {
        DynamicList<E> snap = new DynamicList<>();
        list.forEach(snap::add);
        return snap;
    }


    @Override
    public synchronized Iterator iterator() {
        return copy(dynamicList).iterator();
    }
}
