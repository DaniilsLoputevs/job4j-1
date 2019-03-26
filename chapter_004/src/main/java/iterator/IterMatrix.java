package iterator;

import java.util.Iterator;

/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 01$
 * @since 25.03.2019
 */
public class IterMatrix implements Iterator {

    private final int[][] array;
    int row;
    int column;

    public IterMatrix(int[][] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        boolean rs = false;
        if (row < array.length && column < array.length){
            rs = true;
        }
        return rs ;
    }

    @Override
    public Object next() {
        return array[row++][column++];
    }
}
