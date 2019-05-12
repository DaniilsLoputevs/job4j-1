package ru.job4j.tree;

import java.util.*;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version $
 * @since
 */
public class MyTree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;
    private int modcount;

    /**
     * Конструктор инициализирующий корень
     *
     * @param root - корень
     */
    public MyTree(E root) {
        this.root = new Node<E>(root);
        this.modcount = 0;
    }

    /**
     * Метод добавляения дочернего элемента с указанием родителя
     *
     * @param parent родитель
     * @param child  дочерний элемент
     * @return true/false
     */
    @Override
    public boolean add(E parent, E child) {
        boolean rs = false;
        if (!this.findBy(child).isPresent()) {
            this.findBy(parent).ifPresent(find -> find.add(new Node<>(child)));
            rs = true;
            this.modcount++;
        }
        return rs;
    }

    /**
     * Метод поиска по дереву , реализующий алгоритм поиска в ширину
     *
     * @param value искомое значение
     * @return Optional
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    /**
     * Метод проверки дерева на бинарность.
     *
     * @return true/false
     */
    public boolean isBinary() {
        boolean rs = true;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(this.root);
        while (!queue.isEmpty()) {
            Node<E> check = queue.poll();
            for (Node<E> child : check.leaves()) {
                if (check.leaves().size() > 2) {
                    rs = false;
                }
                queue.offer(child);
            }

        }
        return rs;
    }

    /**
     * Реализация итератора
     *
     * @return
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Queue<Node<E>> queue = new LinkedList<>();
            int checkmod = modcount;

            {
                this.queue.offer(root);
            }

            public boolean checkmodif() {
                boolean rs = false;
                if (checkmod == modcount) {
                    rs = true;
                } else {
                    throw new ConcurrentModificationException();
                }
                return rs;
            }

            @Override
            public boolean hasNext() {
                boolean rs = false;
                if (checkmodif()) {
                    rs = !this.queue.isEmpty();
                }
                return rs;
            }

            @Override
            public E next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<E> value = this.queue.remove();
                for (Node<E> child : value.leaves()) {
                    this.queue.offer(child);
                }
                return value.getValue();
            }
        };
    }

}
