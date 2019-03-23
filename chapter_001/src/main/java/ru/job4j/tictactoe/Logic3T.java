package ru.job4j.tictactoe;
/**
 * Package for TicTacToe JavaFX
 *
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1
 * @since 30.06.2018
 */

import java.util.function.Predicate;


public class Logic3T {

    private final Figure3T[][] table;


    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    /**
     * @param predicate функц интерфейс
     * @param startX    - starting position on line.
     * @param startY    - starting position on column.
     * @param deltaX    - movement by line.
     * @param deltaY    - movement by column.
     * @return result true/false.
     */

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    /**
     * Check victory for X
     *
     * @return Check X combination.
     */

    public boolean isWinnerX() {
        //check:  movement by first vertical.
        return this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 0)
                ||
                //check:  movement by second vertical
                this.fillBy(Figure3T::hasMarkX, 0, 1, 1, 0)
                ||
                // check: movement by last vertical.
                this.fillBy(Figure3T::hasMarkX, table.length - 1, table.length - 1, -1, 0)
                ||
                //check:  movement by first horizontal.
                this.fillBy(Figure3T::hasMarkX, 0, 0, 0, 1)
                ||
                //check: movement by second horizontal.
                this.fillBy(Figure3T::hasMarkX, 1, 0, 0, 1)
                ||
                //check: movement by last horizontal,
                this.fillBy(Figure3T::hasMarkX, table.length - 1, 0, 0, 1)
                ||
                //check: movement by inverse diagonal.
                this.fillBy(Figure3T::hasMarkX, table.length - 1, table.length - 1, 0, -1)
                ||
                // check: movement diagonal left-right.
                this.fillBy(Figure3T::hasMarkX, table.length - 1, 0, -1, 1)
                ||
                //check:  movement by  diagonal.
                this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 1);


    }

    /**
     * Check victory for O
     *
     * @return Check O combination .
     */

    public boolean isWinnerO() {
        //check:  movement by first vertical.
        return this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 0)
                ||
                //check:  movement by second vertical
                this.fillBy(Figure3T::hasMarkO, 0, 1, 1, 0)
                ||
                // check: movement by last vertical.
                this.fillBy(Figure3T::hasMarkO, table.length - 1, table.length - 1, -1, 0)
                ||
                //check:  movement by first horizontal.
                this.fillBy(Figure3T::hasMarkO, 0, 0, 0, 1)
                ||
                //check: movement by second horizontal.
                this.fillBy(Figure3T::hasMarkO, 1, 0, 0, 1)
                ||
                //check: movement by last horizontal,
                this.fillBy(Figure3T::hasMarkO, table.length - 1, 0, 0, 1)
                ||
                //check: movement by inverse diagonal.
                this.fillBy(Figure3T::hasMarkO, table.length - 1, table.length - 1, 0, -1)
                ||
                // check: movement diagonal left-right.
                this.fillBy(Figure3T::hasMarkO, table.length - 1, 0, -1, 1)
                ||
                //check:  movement by  diagonal.
                this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 1);
    }

    /**
     * Check free Cell in table
     *
     * @return check clearCell
     */
    public boolean hasGap() {
        boolean clearCell = false;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if (!table[i][j].hasMarkO() && !table[i][j].hasMarkX()) {
                    clearCell = true;
                    break;
                }
            }
        }
        return clearCell;
    }
}