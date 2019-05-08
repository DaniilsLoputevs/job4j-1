package ru.job4j.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class MyTreeTest {

    @Test
    public void when6ElFindLastThen6() {
        MyTree<Integer> tree = new MyTree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void testNonDuplicateChild() {
        MyTree<Integer> myTree = new MyTree<>(100);
        myTree.add(100, 25);
        myTree.add(100, 46);
        assertThat(myTree.add(46, 25), is(false));
        assertThat(myTree.add(100, 25), is(false));
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        MyTree<Integer> tree = new MyTree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void iterator() {
        MyTree<String> test = new MyTree<>("Value 1");
        test.add("Value 1", "Value 2");
        Iterator<String> iterator = test.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("Value 1"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is("Value 2"));
        assertThat(iterator.hasNext(), is(false));
    }
}