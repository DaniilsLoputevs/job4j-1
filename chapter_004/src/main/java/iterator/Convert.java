package iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 01.$
 * @since 27.03.2019
 */
public class Convert {


    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {

        return new Iterator<Integer>() {

            Iterator<Integer> integerIterator = it.next();

            @Override
            public boolean hasNext() {
                while (!integerIterator.hasNext() && it.hasNext()) {
                    integerIterator = it.next();
                }
                return integerIterator.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return integerIterator.next();
            }
        };
    }

}
